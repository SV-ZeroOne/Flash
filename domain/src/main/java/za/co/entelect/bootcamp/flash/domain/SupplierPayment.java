package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
@javax.persistence.Entity
@Table(name = "SupplierPayments")
public class SupplierPayment implements Entities<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID", nullable = false)
    private int paymentID;
    @Column(name = "OrderID")
    private int orderID;
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "ProcessedDate")
    private Date processedDate;

    public SupplierPayment(){}

    public SupplierPayment(int paymentID, int orderID, BigDecimal total, Date processedDate) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.total = total;
        this.processedDate = processedDate;
    }

    public Integer getID() {
        return this.paymentID;
    }

    public void setID(Integer entityKey) {
        this.paymentID = entityKey;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }
}
