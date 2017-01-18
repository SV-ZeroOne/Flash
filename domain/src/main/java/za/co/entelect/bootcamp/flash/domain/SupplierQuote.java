package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */

@javax.persistence.Entity
@Table(name = "SupplierQuotes")
public class SupplierQuote implements Entity<Integer> {

    @Id @GeneratedValue
    @Column(name = "QuoteID", nullable = false)
    private int quoteID;
    @Column(name = "SupplierID")
    private int supplierID;
    @Column(name = "IssueID")
    private int issueID;
    @Column(name = "Price")
    private double price;
    @Column(name = "EffectiveDate")
    private Date effectiveDate;

    @OneToOne
    @JoinColumn(name = "IssueID")
    private Issue issue;

    public SupplierQuote(){}

    public Integer getID() {
        return this.quoteID;
    }

    public void setID(Integer entityKey) {
        this.quoteID = entityKey;
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
