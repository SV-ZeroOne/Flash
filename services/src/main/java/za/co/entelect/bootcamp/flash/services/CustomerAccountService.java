package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.persistence.Implementation.CustomerAccountsRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class CustomerAccountService {

    private CustomerAccountsRepository customerAccountsRepository;

    public CustomerAccountService(CustomerAccountsRepository customerAccountsRepository) {
        this.customerAccountsRepository = customerAccountsRepository;
    }

    public void createCustomerAccount(CustomerAccounts newCustomer){
        customerAccountsRepository.create(newCustomer);
    }
}
