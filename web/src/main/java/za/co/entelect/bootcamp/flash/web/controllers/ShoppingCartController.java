package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.ShoppingCart;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.Implementations.ShoppingCartRepository;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.ShoppingCartService;
import za.co.entelect.bootcamp.flash.services.StockService;

import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/02/02.
 */

@Controller
public class ShoppingCartController {
    private StockService stockService;
    private ShoppingCartService shoppingCartService;
    private CustomerAccountService customerAccountService;

    @Autowired
    public ShoppingCartController(StockService stockService,
                                  ShoppingCartService shoppingCartService,
                                  CustomerAccountService customerAccountService) {
        this.stockService = stockService;
        this.shoppingCartService = shoppingCartService;
        this.customerAccountService = customerAccountService;
    }

    @RequestMapping(value = "/shopping-cart",method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        CustomerAccounts customerAccounts = customerAccountService
                .getCustomerAccountsRepository()
                .getCustomerAccountByUsername(userName);

        ArrayList<ShoppingCart> shoppingCartItems = shoppingCartService
                .getShoppingCartRepository()
                .getUserCartItems(customerAccounts.getID());

        ArrayList<Stock> cartItemsStock = new ArrayList<Stock>();
        for (ShoppingCart sc : shoppingCartItems) {
            cartItemsStock.add(stockService.getStockRepository().read(sc.getStockByStockId().getID()));
        }

        model.addAttribute("shoppingCartItems", shoppingCartItems);
        model.addAttribute("cartItemsStock", cartItemsStock);

        return "shoppingcart";
    }
}
