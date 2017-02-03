package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.entelect.bootcamp.flash.domain.*;
import za.co.entelect.bootcamp.flash.services.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/02/02.
 */

@Controller
public class CheckoutController {

    private ShoppingCartService shoppingCartService;
    private StockService stockService;
    private CustomerAccountService customerAccountService;
    private CustomerAddressService customerAddressService;
    private EmailAddressService emailAddressService;
    private PhoneNumberService phoneNumberService;
    private CustomerOrderService customerOrderService;

    private CustomerAccounts customerAccount;
    private CustomerAddress customerAddress;
    private EmailAddress emailAddress;
    private PhoneNumbers phoneNumber;
    private ArrayList<ShoppingCart> shoppingCartItems;
    private ArrayList<Stock> cartItemsStock;
    double cartTotal,deliveryCost, orderCost;
    private String subTotal, deliveryTotal, orderTotal, deliveryMethod;

    @Autowired
    public CheckoutController(ShoppingCartService shoppingCartService,
                              StockService stockService,
                              CustomerAccountService customerAccountService,
                              CustomerAddressService customerAddressService,
                              EmailAddressService emailAddressService,
                              PhoneNumberService phoneNumberService,
                              CustomerOrderService customerOrderService) {
        this.shoppingCartService = shoppingCartService;
        this.stockService = stockService;
        this.customerAccountService = customerAccountService;
        this.customerAddressService = customerAddressService;
        this.emailAddressService = emailAddressService;
        this.phoneNumberService = phoneNumberService;
        this.customerOrderService = customerOrderService;
    }

    @RequestMapping(value = "/shopping-cart",method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        cartTotal = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        customerAccount = customerAccountService
                .getCustomerAccountsRepository()
                .getCustomerAccountByUsername(userName);

        shoppingCartItems = shoppingCartService
                .getShoppingCartRepository()
                .getUserCartItems(customerAccount.getID());

        cartItemsStock = new ArrayList<Stock>();
        for (ShoppingCart sc : shoppingCartItems) {
            cartTotal += sc.getCartItemPrice().doubleValue();
            cartItemsStock.add(stockService.getStockRepository().read(sc.getStockByStockId().getID()));
        }

        subTotal = df.format(cartTotal);

        model.addAttribute("shoppingCartItems", shoppingCartItems);
        model.addAttribute("cartItemsStock", cartItemsStock);
        model.addAttribute("subTotal", subTotal);

        return "shoppingcart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        customerAccount = customerAccountService
                .getCustomerAccountsRepository()
                .getCustomerAccountByUsername(userName);

        customerAddress = customerAddressService
                .getCustomerAddressRepository()
                .getAddressByCustomerID(customerAccount.getID());

        emailAddress = emailAddressService
                .getEmailAddressRepository()
                .getEmailByCustomerID(customerAccount.getID());

        phoneNumber = phoneNumberService
                .getPhoneNumbersRepository()
                .getPhoneNumberByCustomerID(customerAccount.getID());

        model.addAttribute("customerAccount", customerAccount);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("phoneNumber", phoneNumber);

        return "checkout";
    }

    @RequestMapping(value = "/payment-details", method = RequestMethod.GET)
    public String completeCheckout(@RequestParam String deliveryOpt, ModelMap model) {

        deliveryMethod = deliveryOpt;
        deliveryCost = 0;
        if (deliveryOpt.equals("Collect")) {
            deliveryCost = 0.00;
        } else if (deliveryOpt.equals("Express")) {
            deliveryCost = 50.00;
        } else if (deliveryOpt.equals("Business")) {
            deliveryCost = 100.00;
        }


        DecimalFormat df = new DecimalFormat("#.00");
        deliveryTotal = df.format(deliveryCost);

        orderCost = cartTotal + deliveryCost;
        orderTotal = df.format(orderCost);

        model.addAttribute("shoppingCartItems", shoppingCartItems);
        model.addAttribute("cartItemsStock", cartItemsStock);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("customerAccount", customerAccount);
        model.addAttribute("customerAddress", customerAddress);
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("deliveryTotal", deliveryTotal);
        model.addAttribute("orderTotal", orderTotal);

        return "payment";
    }

    @RequestMapping(value = "/place-order", method = RequestMethod.POST)
    public String placeOrder() {
        CustomerOrders customerOrder = new CustomerOrders();
        customerOrder.setOrderAmount(new BigDecimal(orderCost));
        customerOrder.setOrderDate(new Timestamp(System.currentTimeMillis()));
        customerOrder.setOrderReference(customerAccount.getID() + "-" + customerOrder.getOrderDate());
        customerOrder.setOrderAddress1(customerAddress.getAddress1());
        customerOrder.setOrderAddress2(customerAddress.getAddress2());
        customerOrder.setOrderSuburb(customerAddress.getSuburb());
        customerOrder.setOrderCity(customerAddress.getCity());
        customerOrder.setOrderPostalCode(customerAddress.getPostalCode());
        customerOrder.setOrderPhone(phoneNumber.getPhoneNumber());
        customerOrder.setOrderEmail(emailAddress.getEmail());
        customerOrder.setOrderShippedDate(null);
        customerOrder.setOrderTrackingNumber(null);
        customerOrder.setOrderDeliveryMethod(deliveryMethod);
        customerOrder.setOrderStatus("Pending");
        customerOrder.setCustomerAccountsByCustomerId(customerAccount);

        customerOrderService.getCustomerOrdersRepository().create(customerOrder);

     return "home";
    }
}
