package za.co.entelect.bootcamp.flash.domain;

import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierQuote {
    private int quoteID;
    private int supplierID;
    private int issueID;
    private double price;
    private Date effectiveDate;

    public SupplierQuote(){}

    public int getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
