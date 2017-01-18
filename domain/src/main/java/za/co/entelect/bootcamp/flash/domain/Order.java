package za.co.entelect.bootcamp.flash.domain;

import java.sql.Date;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class Order implements Entity<Integer>{
    private int orderID;
    private Date orderDate;
    private int issueID;
    private short quantityOrdered;
    private double orderTotal;
    private String shipmentReference;
    private Date shipmentDate;
    private String deliveryStatus;
    private int supplierID;

    public Order () {}

    public Order(int orderID, Date orderDate, int issueID, short quantityOrdered, double orderTotal,
                 String shipmentReference, Date shipmentDate, String deliveryStatus, int supplierID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.issueID = issueID;
        this.quantityOrdered = quantityOrdered;
        this.orderTotal = orderTotal;
        this.shipmentReference = shipmentReference;
        this.shipmentDate = shipmentDate;
        this.deliveryStatus = deliveryStatus;
        this.supplierID = supplierID;
    }

    public Integer getID() {
        return orderID;
    }

    public void setID(Integer entityKey) {
        this.orderID = entityKey;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public short getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(short quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getShipmentReference() {
        return shipmentReference;
    }

    public void setShipmentReference(String shipmentReference) {
        this.shipmentReference = shipmentReference;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", issueID=" + issueID +
                ", quantityOrdered=" + quantityOrdered +
                ", orderTotal=" + orderTotal +
                ", shipmentReference='" + shipmentReference + '\'' +
                ", shipmentDate=" + shipmentDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", supplierID=" + supplierID +
                '}';
    }
}
