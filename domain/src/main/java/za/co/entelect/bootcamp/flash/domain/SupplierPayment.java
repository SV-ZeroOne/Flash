package za.co.entelect.bootcamp.flash.domain;

import java.sql.Date;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPayment {

    private int paymentID;
    private int orderID;
    private double total;
    private Date processedDate;

    public SupplierPayment(){}

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
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
