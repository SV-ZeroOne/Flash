package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.ShoppingCart;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.ShoppingCartInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class ShoppingCartRepository extends RepositoryImplementation<Integer, ShoppingCart>
        implements ShoppingCartInterface {
    /*IF EXISTS ( SELECT * FROM ShoppingCart WHERE StockReferenceID = 251 AND CustomerID = 1005 )
    UPDATE ShoppingCart
    SET Quantity = Quantity+1
    WHERE StockReferenceID = 251 AND CustomerID = 1005;
    ELSE
    INSERT INTO ShoppingCart (Quantity, CustomerID, CartItemPrice, StockReferenceID)
    VALUES ();*/

    @Override
    public boolean create(ShoppingCart cartItem) {
        try {
            ShoppingCart existingItem = read(cartItem.getID());
            if (existingItem == null) {
                super.create(cartItem);
            } else {
                cartItem.setQuantity((short) (cartItem.getQuantity()+1));
                super.update(cartItem);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ShoppingCart> getUserCartItems(int userID) {
        Query userCartQuery = entityManager
                .createQuery("SELECT ci FROM ShoppingCart ci INNER JOIN CustomerAccounts ca ON ci.customerAccountsByCustomerId.id = ca.id WHERE ci.customerAccountsByCustomerId.id = :userID")
                .setParameter("userID", userID);
        return (ArrayList<ShoppingCart>) userCartQuery.getResultList();
    }
}
