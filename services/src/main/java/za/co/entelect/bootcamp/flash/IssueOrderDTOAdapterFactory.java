package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class IssueOrderDTOAdapterFactory implements AbstractFactory{

    private int quantity;
    private Issue issue;

    public IssueOrderDTOAdapterFactory(int quantity, Issue issue) {
        this.quantity = quantity;
        this.issue = issue;
    }

    public IssueOrderDTOAdapter createAdapter()
    {
        return new IssueOrderDTOAdapter(quantity,issue);
    }
}
