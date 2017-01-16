package za.co.entelect.bootcamp.flash;

import java.sql.Date;
import java.util.Iterator;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class FacadeInterface {
    public static void main(String[] args) {

        OrderRepository orderRepo;
        IssueRepository issueRepo = new IssueRepository();
        SupplierRepository supplyRepo;

        //Create issues
        Issue issue1 = new Issue(1, "Spiderman", new Date(20170102), "Marvel", Short.valueOf("2"), "Incredible Spiderman");
        Issue issue2 = new Issue(2, "Batman", new Date(20170102), "DC", Short.valueOf("2"), "Incredible Bat");
        issueRepo.add(issue1, 1);
        issueRepo.add(issue2, 2);

        System.out.println("Enter order details: ");

    }
}
