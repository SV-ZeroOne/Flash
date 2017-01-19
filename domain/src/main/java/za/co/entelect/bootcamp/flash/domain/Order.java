package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by kevin.gouws on 2017/01/13.
 */
@javax.persistence.Entity
@Table(name = "Orders")
public class Order implements Entities<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    private int orderID;
    @Column(name = "OrderDate")
    private Date orderDate;
    @Column(name = "IssueID")
    private int issueID;
    @Column(name = "QtyOrdered")
    private short qtyOrdered;

    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "ShipmentRef", columnDefinition="char(10)")
    private String shipmentRef;

    @Temporal(TemporalType.DATE)
    @Column(name = "ShipmentDate")
    private Date shipmentDate;
    @Column(name = "DeliveryStatus")
    private String deliveryStatus;

    @OneToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "SupplierID")
    private int supplierID;

    public Order () {}

    public Order(int orderID, Date orderDate, int issueID, short qtyOrdered, BigDecimal total,
                 String shipmentRef, Date shipmentDate, String deliveryStatus, int supplierID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.issueID = issueID;
        this.qtyOrdered = qtyOrdered;
        this.total = total;
        this.shipmentRef = shipmentRef;
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

    public short getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(short quantityOrdered) {
        this.qtyOrdered = quantityOrdered;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal orderTotal) {
        this.total = orderTotal;
    }

    public String getShipmentRef() {
        return shipmentRef;
    }

    public void setShipmentRef(String shipmentReference) {
        this.shipmentRef = shipmentReference;
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
                ", quantityOrdered=" + qtyOrdered +
                ", orderTotal=" + total +
                ", shipmentReference='" + shipmentRef + '\'' +
                ", shipmentDate=" + shipmentDate +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", supplierID=" + supplierID +
                '}';
    }
}
