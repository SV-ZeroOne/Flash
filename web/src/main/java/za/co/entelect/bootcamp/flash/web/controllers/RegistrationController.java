package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.CustomerAddress;
import za.co.entelect.bootcamp.flash.domain.EmailAddress;
import za.co.entelect.bootcamp.flash.domain.PhoneNumbers;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.CustomerAddressService;
import za.co.entelect.bootcamp.flash.services.EmailAddressService;
import za.co.entelect.bootcamp.flash.services.PhoneNumberService;

/**
 * Created by steve.velcev on 2017/01/31.
 */
@Controller
public class RegistrationController {
    private CustomerAccountService customerAccountService;
    private EmailAddressService emailAddressService;
    private CustomerAddressService customerAddressService;
    private PhoneNumberService phoneNumberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(CustomerAccountService customerService,
                                  EmailAddressService emailAddressService,
                                  CustomerAddressService customerAddressService,
                                  PhoneNumberService phoneNumberService)
    {
        this.customerAccountService = customerService;
        this.emailAddressService = emailAddressService;
        this.customerAddressService = customerAddressService;
        this.phoneNumberService = phoneNumberService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showForm(ModelAndView modelView) {
        modelView.addObject("customer", new WholeCustomer());
//        modelView.addObject("email", new EmailAddress());
//        modelView.addObject("address", new CustomerAddress());
        modelView.setViewName("registration");
        return modelView;
        //return new ModelAndView("registration", "customer", new CustomerAccounts());
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String submit(@ModelAttribute("customer")WholeCustomer customer, BindingResult result, ModelMap model) {
        //Handle validation below
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("firstName", customer.getAccount().getFirstName());
        model.addAttribute("surname", customer.getAccount().getSurname());
        model.addAttribute("userName", customer.getAccount().getUserName());
        //Need to have userName checker
        model.addAttribute("password", customer.getAccount().getPassword());

        //Generate Hashed Password
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String salt = BCrypt.gensalt(12);
        //System.out.println("Byte password: " + customer.getAccount().getPassword());
        //String hashed_password = BCrypt.hashpw(new String(customer.getAccount().getPassword()), salt);
        //System.out.println("String password: " + new String(customer.getAccount().getPassword()));

        model.addAttribute("email", customer.getEmailAddress().getEmail());
        model.addAttribute("address1", customer.getAddress().getAddress1());
        model.addAttribute("address2", customer.getAddress().getAddress2());
        model.addAttribute("suburb", customer.getAddress().getSuburb());
        model.addAttribute("city", customer.getAddress().getCity());
        model.addAttribute("postalCode", customer.getAddress().getCity());
        model.addAttribute("phoneNumber", customer.getPhoneNumber().getPhoneNumber());

        String stringPass = new String(customer.getAccount().getPassword());
        byte[] hashedPass = passwordEncoder.encode(stringPass).getBytes();
        customer.getAccount().setPassword(hashedPass);
        //System.out.println("Back to byte password: " + hashed_password.getBytes());
        //System.out.println("New String Hashed Password: " + new String(customer.getAccount().getPassword()));
        customerAccountService.getCustomerAccountsRepository().create(customer.getAccount());
        //get Newly created customer
        customer.getEmailAddress().setCustomerAccountsByCustomerId(customer.getAccount());
        customer.getEmailAddress().setType("Primary");
        emailAddressService.getEmailAddressRepository().create(customer.getEmailAddress());
        customer.getAddress().setCustomerAccountsByCustomerId(customer.getAccount());
        customer.getAddress().setAddressType("Postal");
        customerAddressService.getCustomerAddressRepository().create(customer.getAddress());
        customer.getPhoneNumber().setCustomerAccountsByCustomerId(customer.getAccount());
        customer.getPhoneNumber().setType("Cellphone");
        phoneNumberService.getPhoneNumbersRepository().create(customer.getPhoneNumber());
        return "accountConfirmation";
    }

}

//Wrapper Inner Class required to create the multiple objects associated with making an account.
class WholeCustomer{
    private CustomerAccounts account;
    private EmailAddress emailAddress;
    private CustomerAddress address;
    private PhoneNumbers phoneNumber;

    public PhoneNumbers getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumbers phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public CustomerAccounts getAccount() {
        return account;
    }

    public void setAccount(CustomerAccounts account) {
        this.account = account;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}
