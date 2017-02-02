package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class OrderDetails implements EntityInterface<Integer> {
    private int detailD;
    private short detailQuantity;
    private CustomerOrders customerOrdersByCustomerOrderId;
    private Stock stockByStockId;

    @Id
    @Column(name = "DetailD", nullable = false)
    public Integer getID() {
        return this.detailD;
    }

    public void setID(Integer entityKey) {
        this.detailD = entityKey;
    }

    @Basic
    @Column(name = "DetailQuantity", nullable = false)
    public short getDetailQuantity() {
        return detailQuantity;
    }

    public void setDetailQuantity(short detailQuantity) {
        this.detailQuantity = detailQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (detailD != that.detailD) return false;
        if (detailQuantity != that.detailQuantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detailD;
        result = 31 * result + (int) detailQuantity;
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

    @ManyToOne
    @JoinColumn(name = "StockReferenceID", referencedColumnName = "StockReferenceID", nullable = false)
    public Stock getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }
}
