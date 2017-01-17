package za.co.entelect.bootcamp.flash.app;

import za.co.entelect.bootcamp.domain.*;
import za.co.entelect.bootcamp.flash.domain.*;
import za.co.entelect.bootcamp.flash.persistence.IssueRepository;
import za.co.entelect.bootcamp.flash.persistence.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.SupplierRepository;
import za.co.entelect.bootcamp.flash.services.*;
import za.co.entelect.bootcamp.services.*;

import java.sql.Date;
import java.util.*;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class FacadeInterface {
    private static int supplierQuoteCounter = 1;
    private static int orderCounter = 1;
    private static OrderRepository orderRepo = new OrderRepository();
    private static IssueRepository issueRepo = new IssueRepository();
    private static SupplierRepository supplyRepo = new SupplierRepository();
    private static Scanner input = new Scanner(System.in);
    private static int choice = 0;
    private static String conditionChoice = "";

    public static void main(String[] args) {

        Issue issue1 = new Issue(1, "Spiderman", new Date(20170102), "Marvel", Short.valueOf("2"), "Incredible Spiderman");
        Issue issue2 = new Issue(2, "Batman", new Date(20170102), "DC", Short.valueOf("11"), "Bat Cave");
        issueRepo.add(issue1);
        issueRepo.add(issue2);

        Supplier supplier1 = new Supplier(1, "Marvel Suppliers", "New York", "123");
        Supplier supplier2 = new Supplier(2, "DC Sellers", "Hill City", "420");
        supplyRepo.add(supplier1);
        supplyRepo.add(supplier2);

        System.out.println("Welcome to Square Eyes Comic Book Store");
        System.out.println("Enter in your order details: ");
        //for(issues.Entry<Integer, Issue> entry : issues.entrySet()){}
        int issueNo = 1;
        for (Issue entry: issueRepo.getAll().values()) {
            System.out.println(issueNo + ": " + entry.getIssueTitle());
            issueNo++;
        }

        issueChoice();

        SupplierQuote newQuote = createQuote(choice);

        System.out.println("Please enter in quantity");
        int quantity = input.nextInt();
        double totalPrice = calculateTotal(newQuote,quantity);

        issue1.addToStock("New",(short)10, 100);
        issue1.addToStock("Old",(short)5, 20);
        issue2.addToStock("New",(short)8, 80);
        issue2.addToStock("Old",(short)4, 20);

        //Validate related supplier, issue and quote exist
        if(!validateSupplier()){
            System.out.println("No suppliers available");
            System.exit(1);
        }

        validateQuote(newQuote);

        //Validate related stock is below a certain threshold
        if(validateStock(issueRepo.getById(choice),quantity, conditionChoice)) {

            //Call a mock supplier web service to place order (using adapter & create new SupplierQuotes app entity)
            IssueOrderDTOAdapterFactory issueDTOFactory = new IssueOrderDTOAdapterFactory(quantity, issueRepo.getById(choice));
            IssueOrderDTO issueDTO = issueDTOFactory.createAdapter();

            SupplierService suppService = new SupplierService() {
                public String placeOrder(IssueOrderDTO issueOrder, String supplierRefNumber, int quantity) {
                    return null;
                }
            };

            suppService.placeOrder(issueDTO, supplyRepo.getById(newQuote.getSupplierID()).getReferenceNumber(), quantity);

            //Save order
            Order newOrder = new Order(orderCounter, new Date(20171230),issueRepo.getById(choice).getID(),(short)quantity,totalPrice,
            "Ref"+orderCounter,new Date(20171230),"Ordered",supplyRepo.getById(issueRepo.getById(choice).getID()).getID());

            //Save payment (create new SupplierPayment app entity)
            SupplierPayment supplierPayment = new SupplierPayment();
            supplierPayment.setPaymentID(orderCounter);
            supplierPayment.setOrderID(newOrder.getID());
            supplierPayment.setProcessedDate(new Date(20171230));
            supplierPayment.setTotal(newOrder.getOrderTotal());


            //Call a mock payment web service (just validate the amount is positive and returns a ref number)
            SupplierPaymentDTOAdapterFactory paymentDTOFactory = new SupplierPaymentDTOAdapterFactory(supplyRepo.getById(issueRepo.getById(choice).getID()), supplierPayment);
            SupplierPaymentDTO paymentDTO = paymentDTOFactory.createAdapter();

            PaymentService payService = new PaymentService() {

                public String makePayment(SupplierPaymentDTO supplierPayment) {
                    if (supplierPayment.getAmount() >= 0) {
                        return "Ref: " + supplierPayment.getPaymentRefNumber();
                    } else {
                        return "Payment Unsuccessful";
                    }
                }
            };

            if (!payService.makePayment(paymentDTO).equals("Payment Unsuccessful")) {
                orderRepo.add(newOrder);
            }
        }

    }

    private static void validateQuote(SupplierQuote someQuote) {
        if(someQuote != null){

        }else{
            System.exit(1);
        }
    }

    private static void issueChoice() {
        System.out.println("Please select issue to order: ");
        choice = input.nextInt();
        validateIssue(choice);
    }

    private static boolean validateIssue(int i) {
        try{
            if(issueRepo.getById(i) != null){
                conditionInput();
                return true;
            }else{
                System.out.println("Issue doenst exist");
                choice = 0;
                issueChoice();
                return false;
            }
        }catch (Exception e){
            System.out.println("Issue validation error");
            return false;
        }
    }

    private static void conditionInput() {
        System.out.println("Please select the condition New/Old: ");
        input.nextLine();
        conditionChoice = input.nextLine();
    }

    private static boolean validateSupplier() {
        for(HashMap.Entry<Integer, Supplier> entry: supplyRepo.getAll().entrySet()){
            if(entry == null){
                return false;
            }
        }
        return true;
    }

    private static boolean validateStock(Issue issue,int quantity, String condition) {;
        for (int i = 0; i < issue.getStock().size(); i++) {
            if(issue.getStock().get(i).getCondition().toUpperCase().equals(condition.toUpperCase()))
            {
                if(issue.getStock().get(i).getAvailableQty()>=quantity)
                {
                    System.out.println("Stock available for "+issue.getIssueTitle()+ " in condition "+issue.getStock().get(i).getCondition());
                    return true;
                }
            }

        }
        System.out.println("Not enough stock available for "+issue.getIssueTitle()+" in condition "+condition);
        return false;
    }

    private static SupplierQuote createQuote (int issueID)
    {
        SupplierQuote supplierQuote = new SupplierQuote();
        supplierQuote.setIssueID(issueID);
        supplierQuote.setPrice(50.00);
        supplierQuote.setEffectiveDate(new Date(20171230));
        supplierQuote.setQuoteID(supplierQuoteCounter);
        supplierQuoteCounter++;
        return supplierQuote;
    }
    private static double calculateTotal(SupplierQuote newQuote, int quantity)
    {
       return newQuote.getPrice() * quantity;
    }

    private static Order createOrder()
    {
        return null;
    }



}
