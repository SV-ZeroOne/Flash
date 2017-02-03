package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import za.co.entelect.bootcamp.flash.domain.*;
import za.co.entelect.bootcamp.flash.services.*;

import javax.validation.Valid;

/**
 * Created by steve.velcev on 2017/01/31.
 */
@Controller
@EnableWebMvc
public class RegistrationController {
    private CustomerAccountService customerAccountService;
    private EmailAddressService emailAddressService;
    private CustomerAddressService customerAddressService;
    private PhoneNumberService phoneNumberService;
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(CustomerAccountService customerService,
                                  EmailAddressService emailAddressService,
                                  CustomerAddressService customerAddressService,
                                  PhoneNumberService phoneNumberService,
                                  UserRoleService userRoleService)
    {
        this.customerAccountService = customerService;
        this.emailAddressService = emailAddressService;
        this.customerAddressService = customerAddressService;
        this.phoneNumberService = phoneNumberService;
        this.userRoleService = userRoleService;
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
    public String submit(@ModelAttribute("customer") @Valid WholeCustomer customer, BindingResult result, ModelMap model) {
        //Handle validation below
        if (result.hasErrors()) {
            System.out.println("Form has errors");
            return "/registration";
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
        //Check if username is unique before creating account.
        if(checkUsername(customer, result)){
            customerAccountService.getCustomerAccountsRepository().create(customer.getAccount());
        }else{
            model.addAttribute("errorMessage", "Username already exists");
            return "/registration";
        }
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
        //create default user role
        UserRoles newRole = new UserRoles();
        newRole.setCustomerAccountsByCustomerId(customer.getAccount());
        newRole.setRole("ROLE_USER");
        userRoleService.getUserRolesRepository().create(newRole);
        return "accountConfirmation";
    }

    private boolean checkUsername(WholeCustomer customer, BindingResult result) {
        String customerUsername = customer.getAccount().getUserName();
        try{
            CustomerAccounts existingCustomer = customerAccountService.getCustomerAccountsRepository().getCustomerAccountByUsername(customerUsername);
            if(existingCustomer != null){
                System.out.println("Found customer with existing user name:");
                return false;
            }else{
                return true;
            }
        }catch (Exception e) {
            return true;
        }

    }

}

//Wrapper Inner Class required to create the multiple objects associated with making an account.
class WholeCustomer{
    @Valid
    private CustomerAccounts account;
    @Valid
    private EmailAddress emailAddress;
    @Valid
    private CustomerAddress address;
    @Valid
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

