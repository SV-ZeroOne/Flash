package za.co.entelect.bootcamp.flash;

import java.sql.Date;
import java.util.*;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class FacadeInterface {
    private static int supplierQuoteCounter = 1;
    public static void main(String[] args) {

        OrderRepository orderRepo;
        IssueRepository issueRepo = new IssueRepository();
        SupplierRepository supplyRepo = new SupplierRepository();

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
        Scanner input = new Scanner(System.in);
        System.out.println("Please select issue to order: ");
        int choice = input.nextInt();

        System.out.println("Please select the condition New/Old: ");
        String conditionChoice = input.nextLine();
        input.nextLine();

        SupplierQuote newQuote = createQuote(choice);


        System.out.println("Please enter in quantity");
        int quantity = input.nextInt();
        double totalPrice = calculateTotal(newQuote,quantity);

        issue1.addToStock("New",(short)10, 100);
        issue1.addToStock("Old",(short)5, 20);
        issue2.addToStock("New",(short)8, 80);
        issue2.addToStock("Old",(short)4, 20);

        //Validate related supplier, issue and quote exist
        validateSupplierIssueQuote();

        //Validate related stock is below a certain threshold
        validateStock(issueRepo.getById(choice),quantity, conditionChoice);

        //Call a mock supplier web service to place order (using adapter & create new SupplierQuotes domain entity)
        IssueOrderDTOAdapterFactory issueDTOFactory = new IssueOrderDTOAdapterFactory(quantity, issueRepo.getById(choice));
        IssueOrderDTO issueDTO = issueDTOFactory.createAdapter();

        SupplierService suppServrice = new SupplierService() {
            public String placeOrder(IssueOrderDTO issueOrder, String supplierRefNumber, int quantity) {
                return null;
            }
        };


        //Save order
        Order someOrder = new Order();

        //Call a mock payment web service (just validate the amount is positive and returns a ref number)


        //Save payment (create new SupplierPayment domain entity)


    }

    private static void validateSupplierIssueQuote() {
    }

    private static boolean validateStock(Issue issue,int quantity, String condition) {
        for (int i = 0; i < issue.getStock().size(); i++) {
            if(issue.getStock().get(i).getCondition().equals(condition))
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
