package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.PhoneNumbers;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.PhoneNumbersInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class PhoneNumbersRepository extends RepositoryImplementation<Integer, PhoneNumbers>
        implements PhoneNumbersInterface {
    public PhoneNumbers getPhoneNumberByCustomerID(int customerID) {
        Query phoneQuery = entityManager
                .createQuery("SELECT pn FROM PhoneNumbers pn WHERE pn.customerAccountsByCustomerId.id = :id")
                .setParameter("id", customerID);
        return (PhoneNumbers) phoneQuery.getSingleResult();
    }
}
