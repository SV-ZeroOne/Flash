package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.CustomerAddress;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.CustomerAddressInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class CustomerAddressRepository extends RepositoryImplementation<Integer, CustomerAddress>
        implements CustomerAddressInterface {

    public CustomerAddress getAddressByCustomerID(int customerID) {
        Query addrQuery = entityManager
                .createQuery("SELECT ca FROM CustomerAddress ca WHERE ca.customerAccountsByCustomerId.id = :id")
                .setParameter("id", customerID);
        return (CustomerAddress) addrQuery.getSingleResult();
    }
}
