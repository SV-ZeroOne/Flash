package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class SupplierPayments implements EntityInterface<Integer> {
    private int paymentId;
    private BigDecimal total;
    private Date processedDate;
    private Orders ordersByOrderId;

    @Id
    @Column(name = "PaymentID", nullable = false)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "Total", nullable = false, precision = 2)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Basic
    @Column(name = "ProcessedDate", nullable = true)
    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierPayments that = (SupplierPayments) o;

        if (paymentId != that.paymentId) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (processedDate != null ? !processedDate.equals(that.processedDate) : that.processedDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (processedDate != null ? processedDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    public Integer getID() {
        return this.paymentId;
    }

    public void setID(Integer entityKey) {
        this.paymentId = entityKey;
    }
}
