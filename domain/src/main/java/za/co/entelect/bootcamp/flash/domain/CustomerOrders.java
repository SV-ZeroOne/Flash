package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class CustomerOrders implements EntityInterface<Integer> {
    private int customerOrderId;
    private BigDecimal orderAmount;
    private Timestamp orderDate;
    private String orderReference;
    private String orderAddress1;
    private String orderAddress2;
    private String orderSuburb;
    private String orderCity;
    private String orderPostalCode;
    private String orderPhone;
    private String orderEmail;
    private Timestamp orderShippedDate;
    private String orderTrackingNumber;
    private String orderDeliveryMethod;
    private String orderStatus;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "CustomerOrderID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return this.customerOrderId;
    }

    public void setID(Integer entityKey) {
        this.customerOrderId = entityKey;
    }

    @Basic
    @Column(name = "OrderAmount", nullable = true, precision = 2)
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "OrderDate", nullable = true)
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "OrderReference", nullable = false, length = 50)
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    @Basic
    @Column(name = "OrderAddress1", nullable = false, length = 100)
    public String getOrderAddress1() {
        return orderAddress1;
    }

    public void setOrderAddress1(String orderAddress1) {
        this.orderAddress1 = orderAddress1;
    }

    @Basic
    @Column(name = "OrderAddress2", nullable = true, length = 100)
    public String getOrderAddress2() {
        return orderAddress2;
    }

    public void setOrderAddress2(String orderAddress2) {
        this.orderAddress2 = orderAddress2;
    }

    @Basic
    @Column(name = "OrderSuburb", nullable = true, length = 50)
    public String getOrderSuburb() {
        return orderSuburb;
    }

    public void setOrderSuburb(String orderSuburb) {
        this.orderSuburb = orderSuburb;
    }

    @Basic
    @Column(name = "OrderCity", nullable = false, length = 50)
    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    @Basic
    @Column(name = "OrderPostalCode", nullable = false, length = 4)
    public String getOrderPostalCode() {
        return orderPostalCode;
    }

    public void setOrderPostalCode(String orderPostalCode) {
        this.orderPostalCode = orderPostalCode;
    }

    @Basic
    @Column(name = "OrderPhone", nullable = true, length = 10)
    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    @Basic
    @Column(name = "OrderEmail", nullable = false, length = 320)
    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    @Basic
    @Column(name = "OrderShippedDate", nullable = true)
    public Timestamp getOrderShippedDate() {
        return orderShippedDate;
    }

    public void setOrderShippedDate(Timestamp orderShippedDate) {
        this.orderShippedDate = orderShippedDate;
    }

    @Basic
    @Column(name = "OrderTrackingNumber", nullable = true, length = 50)
    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    @Basic
    @Column(name = "OrderDeliveryMethod", nullable = false, length = 50)
    public String getOrderDeliveryMethod() {
        return orderDeliveryMethod;
    }

    public void setOrderDeliveryMethod(String orderDeliveryMethod) {
        this.orderDeliveryMethod = orderDeliveryMethod;
    }

    @Basic
    @Column(name = "OrderStatus", nullable = true, length = 20)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrders that = (CustomerOrders) o;

        if (customerOrderId != that.customerOrderId) return false;
        if (orderAmount != null ? !orderAmount.equals(that.orderAmount) : that.orderAmount != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (orderReference != null ? !orderReference.equals(that.orderReference) : that.orderReference != null)
            return false;
        if (orderAddress1 != null ? !orderAddress1.equals(that.orderAddress1) : that.orderAddress1 != null)
            return false;
        if (orderAddress2 != null ? !orderAddress2.equals(that.orderAddress2) : that.orderAddress2 != null)
            return false;
        if (orderSuburb != null ? !orderSuburb.equals(that.orderSuburb) : that.orderSuburb != null) return false;
        if (orderCity != null ? !orderCity.equals(that.orderCity) : that.orderCity != null) return false;
        if (orderPostalCode != null ? !orderPostalCode.equals(that.orderPostalCode) : that.orderPostalCode != null)
            return false;
        if (orderPhone != null ? !orderPhone.equals(that.orderPhone) : that.orderPhone != null) return false;
        if (orderEmail != null ? !orderEmail.equals(that.orderEmail) : that.orderEmail != null) return false;
        if (orderShippedDate != null ? !orderShippedDate.equals(that.orderShippedDate) : that.orderShippedDate != null)
            return false;
        if (orderTrackingNumber != null ? !orderTrackingNumber.equals(that.orderTrackingNumber) : that.orderTrackingNumber != null)
            return false;
        if (orderDeliveryMethod != null ? !orderDeliveryMethod.equals(that.orderDeliveryMethod) : that.orderDeliveryMethod != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerOrderId;
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderReference != null ? orderReference.hashCode() : 0);
        result = 31 * result + (orderAddress1 != null ? orderAddress1.hashCode() : 0);
        result = 31 * result + (orderAddress2 != null ? orderAddress2.hashCode() : 0);
        result = 31 * result + (orderSuburb != null ? orderSuburb.hashCode() : 0);
        result = 31 * result + (orderCity != null ? orderCity.hashCode() : 0);
        result = 31 * result + (orderPostalCode != null ? orderPostalCode.hashCode() : 0);
        result = 31 * result + (orderPhone != null ? orderPhone.hashCode() : 0);
        result = 31 * result + (orderEmail != null ? orderEmail.hashCode() : 0);
        result = 31 * result + (orderShippedDate != null ? orderShippedDate.hashCode() : 0);
        result = 31 * result + (orderTrackingNumber != null ? orderTrackingNumber.hashCode() : 0);
        result = 31 * result + (orderDeliveryMethod != null ? orderDeliveryMethod.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    public CustomerAccounts getCustomerAccountsByCustomerId() {
        return customerAccountsByCustomerId;
    }

    public void setCustomerAccountsByCustomerId(CustomerAccounts customerAccountsByCustomerId) {
        this.customerAccountsByCustomerId = customerAccountsByCustomerId;
    }
}
