package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
@javax.persistence.Entity
@Table(name = "SupplierPayments")
public class SupplierPayment implements Entity<Integer> {

    @Id @GeneratedValue
    @Column(name = "PaymentID", nullable = false)
    private int paymentID;
    @Column(name = "OrderID")
    private int orderID;
    @Column(name = "Total")
    private double total;
    @Column(name = "ProcessedDate")
    private Date processedDate;

    public SupplierPayment(){}

    public SupplierPayment(int paymentID, int orderID, double total, Date processedDate) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }
}
