package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by byron.dinkelmann on 2017/01/13.
 */

@Entity
@Table
public class Stock implements Entities<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StockReferenceID", nullable = false)
    private int stockReferenceID;
    @Column(name = "IssueID")
    private int issueID;
    @Column(name = "Condition")
    private String condition;
    @Column(name = "AvailableQty")
    private short availableQty;
    @Column(name = "Price")
    private BigDecimal price;

    public Stock() {}

    public Stock(int stockReferenceID, int issueID, String condition, short availableQty, BigDecimal price) {
        this.stockReferenceID = stockReferenceID;
        this.issueID = issueID;
        this.condition = condition;
        this.availableQty = availableQty;
        this.price = price;
    }

    public Integer getID() {
        return this.stockReferenceID;
    }

    public void setID(Integer entityKey) {
        this.stockReferenceID = entityKey;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public short getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(short availableQty) {
        this.availableQty = availableQty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockReferenceID=" + stockReferenceID +
                ", issueID=" + issueID +
                ", condition='" + condition + '\'' +
                ", availableQty=" + availableQty +
                ", price=" + price +
                '}';
    }
}
