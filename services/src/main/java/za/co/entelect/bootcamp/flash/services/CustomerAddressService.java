package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.CustomerAddressRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class CustomerAddressService {

    private CustomerAddressRepository customerAddressRepository;

    public CustomerAddressService(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    public CustomerAddressRepository getCustomerAddressRepository() {
        return customerAddressRepository;
    }

    public void setCustomerAddressRepository(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }
}
