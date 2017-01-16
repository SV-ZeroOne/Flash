package za.co.entelect.bootcamp.flash;

public class IssueOrderDTOAdapter {

    private Order order;
    private Issue issue;
    private Supplier supplier;


    public IssueOrderDTOAdapter(Order order, Issue issue, Supplier supplier){
        this.order=order;
        this.issue=issue;
        this.supplier=supplier;
        createIssueOrderDTO();
    }

    public SupplierService.IssueOrderDTO createIssueOrderDTO(){
        SupplierService.IssueOrderDTO dto = new SupplierService.IssueOrderDTO();
        dto.setIssueID(issue.getID());
        dto.setSeriesNumber(String.valueOf(issue.getSeriesNumber()));
        dto.setQuantity(order.getQuantityOrdered());
        return dto;
    }

}
