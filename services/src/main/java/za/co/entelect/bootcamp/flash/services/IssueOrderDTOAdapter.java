package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issue;

public class IssueOrderDTOAdapter extends IssueOrderDTO implements Adapter{

    private int quantity;
    private Issue issue;

    public IssueOrderDTOAdapter(int quantity, Issue issue){
        this.quantity=quantity;
        this.issue=issue;
    }

    @Override
    public int getIssueID() {
        return issue.getID();
    }

    @Override
    public void setIssueID(int issueID) {
        super.setIssueID(issueID);
    }

    @Override
    public String getSeriesNumber() {
        return String.valueOf(issue.getSeriesNumber());
    }

    @Override
    public void setSeriesNumber(String seriesNumber) {
        super.setSeriesNumber(seriesNumber);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    public void createAdapter() {

    }
}
