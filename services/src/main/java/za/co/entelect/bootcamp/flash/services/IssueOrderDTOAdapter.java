package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issue;

@Deprecated
public class IssueOrderDTOAdapter extends IssueOrderDTO {

    private Issue issue;
    private int quantity;

    public IssueOrderDTOAdapter(Issue issue, int quantity){
        this.issue = issue;
        this.quantity = quantity;
    }

    @Override
    public int getIssueID() {
        return this.issue.getID();
    }

    @Override
    public void setIssueID(int issueID) {
        super.setIssueID(issueID);
    }

    @Override
    public String getSeriesNumber() {
        return String.valueOf(this.issue.getSeriesNumber());
    }

    @Override
    public void setSeriesNumber(String seriesNumber) {
        super.setSeriesNumber(seriesNumber);
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

}
