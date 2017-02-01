package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class CustomerAccountsRepository extends RepositoryImplementation<Integer, CustomerAccounts>
        implements CustomerAccountsInterface {

    public CustomerAccounts getCustomerAccountByUsername(String userName){
        Query userNameQuery = entityManager
                .createQuery("SELECT ca FROM CustomerAccounts ca WHERE ca.userName = :userName")
                .setParameter("userName", userName);
        return (CustomerAccounts) userNameQuery.getSingleResult();
    }
}
