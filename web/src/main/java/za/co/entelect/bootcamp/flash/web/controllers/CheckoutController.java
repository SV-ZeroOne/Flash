package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.CustomerAddress;
import za.co.entelect.bootcamp.flash.domain.EmailAddress;
import za.co.entelect.bootcamp.flash.domain.PhoneNumbers;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.CustomerAddressService;
import za.co.entelect.bootcamp.flash.services.EmailAddressService;
import za.co.entelect.bootcamp.flash.services.PhoneNumberService;

/**
 * @author kevin.gouws - Created on 2017/02/02.
 */

@Controller
public class CheckoutController {

    private CustomerAccountService customerAccountService;
    private CustomerAddressService customerAddressService;
    private EmailAddressService emailAddressService;
    private PhoneNumberService phoneNumberService;

    @Autowired
    public CheckoutController(CustomerAccountService customerAccountService,
                              CustomerAddressService customerAddressService,
                              EmailAddressService emailAddressService,
                              PhoneNumberService phoneNumberService) {
        this.customerAccountService = customerAccountService;
        this.customerAddressService = customerAddressService;
        this.emailAddressService = emailAddressService;
        this.phoneNumberService = phoneNumberService;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        CustomerAccounts customerAccount = customerAccountService
                .getCustomerAccountsRepository()
                .getCustomerAccountByUsername(userName);

        CustomerAddress customerAddress = customerAddressService
                .getCustomerAddressRepository()
                .getAddressByCustomerID(customerAccount.getID());

        EmailAddress emailAddress = emailAddressService
                .getEmailAddressRepository()
                .getEmailByCustomerID(customerAccount.getID());

        PhoneNumbers phoneNumber = phoneNumberService
                .getPhoneNumbersRepository()
                .getPhoneNumberByCustomerID(customerAccount.getID());

        model.addAttribute("customerAccount", customerAccount);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("phoneNumber", phoneNumber);



        return "checkout-details";
    }
}
