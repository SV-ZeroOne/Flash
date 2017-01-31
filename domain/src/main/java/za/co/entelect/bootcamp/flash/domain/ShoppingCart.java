package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class ShoppingCart implements EntityInterface<Integer> {
    private int shoppingCartId;
    private short quantity;
    private BigDecimal cartItemPrice;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "ShoppingCartID", nullable = false)
    public Integer getID() {
        return this.shoppingCartId;
    }

    public void setID(Integer entityKey) {
        this.shoppingCartId = entityKey;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "CartItemPrice", nullable = true, precision = 2)
    public BigDecimal getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(BigDecimal cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (shoppingCartId != that.shoppingCartId) return false;
        if (quantity != that.quantity) return false;
        if (cartItemPrice != null ? !cartItemPrice.equals(that.cartItemPrice) : that.cartItemPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingCartId;
        result = 31 * result + (int) quantity;
        result = 31 * result + (cartItemPrice != null ? cartItemPrice.hashCode() : 0);
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
