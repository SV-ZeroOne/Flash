package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class Stock implements EntityInterface<Integer> {
    private int stockReferenceId;
    private String condition;
    private Short availableQty;
    private BigDecimal price;
    private Issues issuesByIssueId;

    @Id
    @Column(name = "StockReferenceID", nullable = false)
    public Integer getID() {
        return this.stockReferenceId;
    }

    public void setID(Integer entityKey) {
        this.stockReferenceId = entityKey;
    }

    @Basic
    @Column(name = "Condition", nullable = true, length = 10)
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "AvailableQty", nullable = true)
    public Short getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Short availableQty) {
        this.availableQty = availableQty;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (stockReferenceId != stock.stockReferenceId) return false;
        if (condition != null ? !condition.equals(stock.condition) : stock.condition != null) return false;
        if (availableQty != null ? !availableQty.equals(stock.availableQty) : stock.availableQty != null) return false;
        if (price != null ? !price.equals(stock.price) : stock.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockReferenceId;
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (availableQty != null ? availableQty.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IssueID", referencedColumnName = "IssueID")
    public Issues getIssuesByIssueId() {
        return issuesByIssueId;
    }

    public void setIssuesByIssueId(Issues issuesByIssueId) {
        this.issuesByIssueId = issuesByIssueId;
    }
}
