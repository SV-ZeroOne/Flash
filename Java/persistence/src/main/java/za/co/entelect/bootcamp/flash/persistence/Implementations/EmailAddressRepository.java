package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.EmailAddress;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.EmailAddressInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class EmailAddressRepository extends RepositoryImplementation<Integer, EmailAddress>
        implements EmailAddressInterface {
    public EmailAddress getEmailByCustomerID(int customerID) {
        Query emailQuery = entityManager
                .createQuery("SELECT ea FROM EmailAddress ea WHERE ea.customerAccountsByCustomerId.id = :id")
                .setParameter("id", customerID);
        return (EmailAddress) emailQuery.getSingleResult();
    }
}
