package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.ShoppingCart;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.ShoppingCartService;
import za.co.entelect.bootcamp.flash.services.StockService;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */

@Controller
public class ProductController {
    private CustomerAccountService customerAccountService;
    private StockService stockService;
    private ShoppingCartService shoppingCartService;
    private Stock comicStock;

    @Autowired
    public ProductController(StockService stockService,
                             CustomerAccountService customerAccountService,
                             ShoppingCartService shoppingCartService) {
        this.stockService = stockService;
        this.customerAccountService = customerAccountService;
        this.shoppingCartService = shoppingCartService;
        comicStock = null;
    }

    @RequestMapping(value = "/issue", method = RequestMethod.GET)
    public String getProductPage(@RequestParam int id,
                                 @RequestParam String condition,
                                 ModelMap model) {
        comicStock = stockService.getStockRepository().getComicStock(id, condition);
        model.addAttribute("comicStock", comicStock);
        return "product";
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public String addProductToCart() {

        // Get customer account using their username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        CustomerAccounts customerAccounts = customerAccountService
                .getCustomerAccountsRepository()
                .getCustomerAccountByUsername(userName);

        // Get stock by the stock id
        // using class variable

        // create cart item
        ShoppingCart cartItem = new ShoppingCart();
        cartItem.setQuantity((short) 1);
        cartItem.setCartItemPrice(comicStock.getPrice());
        cartItem.setCustomerAccountsByCustomerId(customerAccounts);
        cartItem.setStockByStockId(comicStock);

        //persist the cart item to the DB
        shoppingCartService.getShoppingCartRepository().create(cartItem);

        return "home";
    }
}
