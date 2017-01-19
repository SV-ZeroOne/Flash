package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */

@javax.persistence.Entity
@Table(name = "SupplierQuotes")
public class SupplierQuote implements Entities<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuoteID", nullable = false)
    private int quoteID;

    @Column(name = "SupplierID")
    private int supplierID;

//    @OneToOne (targetEntity = Issue.class)
//    private int issueID;
    @Column(name = "Price" )
    private BigDecimal price;
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

//    public int getIssueID() {
//        return issueID;
//    }
//
//    public void setIssueID(int issueID) {
//        this.issueID = issueID;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
