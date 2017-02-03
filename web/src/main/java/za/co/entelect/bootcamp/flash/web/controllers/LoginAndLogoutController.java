package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.StockService;
import za.co.entelect.bootcamp.flash.web.config.CustomUserDetailsService;

import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by steve.velcev on 2017/02/02.
 */
@Controller
public class LoginAndLogoutController {

    private StockService stockService;

    @Autowired
    public LoginAndLogoutController(StockService stockService) {
        this.stockService = stockService;
    }

    @Autowired
    CustomerAccountService customerAccountService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model, Principal principal) {
        try{
            CustomerAccounts customer = customerAccountService.getCustomerAccountsRepository().getCustomerAccountByUsername(principal.getName());
            if(customer != null){
                ArrayList<Stock> featuredStock = stockService.getStockRepository().getFeaturedComicsStock();
                ArrayList<Stock> specialStock = stockService.getStockRepository().getSpecialsComicStock();
                ArrayList<Stock> topStock = stockService.getStockRepository().getTopSellingComicStock();
                ArrayList<Stock> newStock = stockService.getStockRepository().getNewComicStock();
                model.addAttribute("featuredStock", featuredStock);
                model.addAttribute("specialStock", specialStock);
                model.addAttribute("topStock", topStock);
                model.addAttribute("newStock", newStock);
                return "home";
            }else{
                return "/login";
            }

        }catch (Exception e){
            System.out.println("Could not find login user.");
            return "/login";
        }
    }

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logout() {
//        return "/home";
//    }

}
