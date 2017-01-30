package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class SupplierQuotes implements EntityInterface<Integer> {
    private int quoteId;
    private BigDecimal price;
    private Timestamp effectiveDate;
    private Issues issuesByIssueId;

    @Id
    @Column(name = "QuoteID", nullable = false)
    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "EffectiveDate", nullable = false)
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierQuotes that = (SupplierQuotes) o;

        if (quoteId != that.quoteId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quoteId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IssueID", referencedColumnName = "IssueID", nullable = false)
    public Issues getIssuesByIssueId() {
        return issuesByIssueId;
    }

    public void setIssuesByIssueId(Issues issuesByIssueId) {
        this.issuesByIssueId = issuesByIssueId;
    }

    public Integer getID() {
        return this.quoteId;
    }

    public void setID(Integer entityKey) {
        this.quoteId = entityKey;
    }
}
