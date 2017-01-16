package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class IssueOrderDTOAdapterFactory {

    Adapter createIssueOrderDTOAdapter(int quantity, Issue issue){
       return new IssueOrderDTOAdapter(quantity,issue);
    }
}
