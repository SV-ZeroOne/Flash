package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class Invoice implements EntityInterface<Integer> {
    private int invoiceId;
    private String invoiceNumber;
    private Timestamp invoiceDate;
    private CustomerOrders customerOrdersByCustomerOrderId;

    @Id
    @Column(name = "InvoiceID", nullable = false)
    public Integer getID() {
        return this.invoiceId;
    }

    public void setID(Integer entityKey) {
        this.invoiceId = entityKey;
    }

    @Basic
    @Column(name = "InvoiceNumber", nullable = false, length = 50)
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Basic
    @Column(name = "InvoiceDate", nullable = true)
    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (invoiceId != invoice.invoiceId) return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(invoice.invoiceNumber) : invoice.invoiceNumber != null)
            return false;
        if (invoiceDate != null ? !invoiceDate.equals(invoice.invoiceDate) : invoice.invoiceDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceId;
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerOrderID", referencedColumnName = "CustomerOrderID", nullable = false)
    public CustomerOrders getCustomerOrdersByCustomerOrderId() {
        return customerOrdersByCustomerOrderId;
    }

    public void setCustomerOrdersByCustomerOrderId(CustomerOrders customerOrdersByCustomerOrderId) {
        this.customerOrdersByCustomerOrderId = customerOrdersByCustomerOrderId;
    }
}
