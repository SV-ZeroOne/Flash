package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.CustomerOrdersRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class CustomerOrderService {

    private CustomerOrdersRepository customerOrdersRepository;

    public CustomerOrderService(CustomerOrdersRepository customerOrdersRepository) {
        this.customerOrdersRepository = customerOrdersRepository;
    }
}
