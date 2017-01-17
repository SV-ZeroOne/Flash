package za.co.entelect.bootcamp.flash;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class FacadeInterface {
    public static void main(String[] args) {

        OrderRepository orderRepo;
        IssueRepository issueRepo = new IssueRepository();
        SupplierRepository supplyRepo = new SupplierRepository();

        Issue issue1 = new Issue(1, "Spiderman", new Date(20170102), "Marvel", Short.valueOf("2"), "Incredible Spiderman");
        Issue issue2 = new Issue(2, "Batman", new Date(20170102), "DC", Short.valueOf("11"), "Bat Cave");
        issueRepo.add(issue1, 1);
        issueRepo.add(issue2, 2);

        Supplier supplier1 = new Supplier(1, "Marvel Suppliers", "New York", "123");
        Supplier supplier2 = new Supplier(2, "DC Sellers", "Hill City", "420");
        supplyRepo.add(supplier1, 1);
        supplyRepo.add(supplier2, 2);

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
        System.out.println("Please enter in quantity");
        int quantity = input.nextInt();

        //Validate related supplier, issue and quote exist
        validateSupplierIssueQuote();
        //Validate related stock is below a certain threshold
        validateStock();
        //Call a mock supplier web service to place order (using adapter & create new SupplierQuotes domain entity)
        IssueOrderDTOAdapterFactory issueDTOFactory = new IssueOrderDTOAdapterFactory(quantity, issueRepo.getById(choice));
        IssueOrderDTO issueDTO = issueDTOFactory.createAdapter();

        SupplierService suppServrice = new SupplierService() {
            public String placeOrder(IssueOrderDTO issueOrder, String supplierRefNumber, int quantity) {
                return null;
            }
        };

        SupplierQuote supplierQuote = new SupplierQuote();

        //Save order
        Order someOrder = new Order();

        //Call a mock payment web service (just validate the amount is positive and returns a ref number)


        //Save payment (create new SupplierPayment domain entity)


    }

    private static void validateSupplierIssueQuote() {
    }

    private static void validateStock() {
    }

}
