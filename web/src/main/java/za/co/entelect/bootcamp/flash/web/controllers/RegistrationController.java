package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;

/**
 * Created by steve.velcev on 2017/01/31.
 */
@Controller
public class RegistrationController {
    private CustomerAccountService customerAccountService;

    @Autowired
    public RegistrationController(CustomerAccountService customerService){
        this.customerAccountService = customerService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("registration", "customer", new CustomerAccounts());
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String submit(@ModelAttribute("customer")CustomerAccounts customer,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("surname", customer.getSurname());
        model.addAttribute("password", customer.getPassword());
        customerAccountService.createCustomerAccount(customer);
        return "accountConfirmation";
    }

}
