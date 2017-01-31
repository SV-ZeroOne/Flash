package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class Orders implements EntityInterface<Integer> {
    private int orderId;
    private Date orderDate;
    private Short qtyOrdered;
    private BigDecimal total;
    private String shipmentRef;
    private Date shipmentDate;
    private String deliveryStatus;
    private Issues issuesByIssueId;

    @Id
    @Column(name = "OrderID", nullable = false)
    public Integer getID() {
        return this.orderId;
    }

    public void setID(Integer entityKey) {
        this.orderId = entityKey;
    }

    @Basic
    @Column(name = "OrderDate", nullable = true)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "QtyOrdered", nullable = true)
    public Short getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(Short qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    @Basic
    @Column(name = "Total", nullable = true, precision = 2)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Basic
    @Column(name = "ShipmentRef", nullable = true, columnDefinition = "char(10)")
    public String getShipmentRef() {
        return shipmentRef;
    }

    public void setShipmentRef(String shipmentRef) {
        this.shipmentRef = shipmentRef;
    }

    @Basic
    @Column(name = "ShipmentDate", nullable = true)
    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    @Basic
    @Column(name = "DeliveryStatus", nullable = true, length = 20)
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (qtyOrdered != null ? !qtyOrdered.equals(orders.qtyOrdered) : orders.qtyOrdered != null) return false;
        if (total != null ? !total.equals(orders.total) : orders.total != null) return false;
        if (shipmentRef != null ? !shipmentRef.equals(orders.shipmentRef) : orders.shipmentRef != null) return false;
        if (shipmentDate != null ? !shipmentDate.equals(orders.shipmentDate) : orders.shipmentDate != null)
            return false;
        if (deliveryStatus != null ? !deliveryStatus.equals(orders.deliveryStatus) : orders.deliveryStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (qtyOrdered != null ? qtyOrdered.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (shipmentRef != null ? shipmentRef.hashCode() : 0);
        result = 31 * result + (shipmentDate != null ? shipmentDate.hashCode() : 0);
        result = 31 * result + (deliveryStatus != null ? deliveryStatus.hashCode() : 0);
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
