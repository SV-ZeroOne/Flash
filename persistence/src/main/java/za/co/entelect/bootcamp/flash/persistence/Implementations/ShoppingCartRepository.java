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

//    @Override
//    public boolean create(ShoppingCart cartItem) {
//        Query checkQ = entityManager.createQuery("")
//        return false;
//    }

    public ArrayList<ShoppingCart> getUserCartItems(int userID) {
        Query userCartQuery = entityManager
                .createQuery("SELECT ci FROM ShoppingCart ci INNER JOIN CustomerAccounts ca ON ci.customerAccountsByCustomerId.id = ca.id WHERE ci.customerAccountsByCustomerId.id = :userID")
                .setParameter("userID", userID);
        return (ArrayList<ShoppingCart>) userCartQuery.getResultList();
    }
}
