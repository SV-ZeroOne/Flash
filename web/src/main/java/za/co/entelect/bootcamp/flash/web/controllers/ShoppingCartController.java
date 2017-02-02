package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.services.StockService;

/**
 * @author kevin.gouws - Created on 2017/02/02.
 */

@Controller
public class ShoppingCartController {
    private StockService stockService;

    @Autowired
    public ShoppingCartController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/shopping-cart",method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        model.addAttribute("userName", userName);
        return "shoppingcart";
    }
}
