package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.services.StockService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Controller
@RequestMapping({"/", "/#", "/home", "/login?", "/login**"})
public class HomeController {
    private StockService stockService;

    @Autowired
    public HomeController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        ArrayList<Stock> featuredStock = stockService.getStockRepository().getFeaturedComicsStock();
        ArrayList<Stock> specialStock = stockService.getStockRepository().getSpecialsComicStock();
        ArrayList<Stock> topStock = stockService.getStockRepository().getTopSellingComicStock();
        ArrayList<Stock> newStock = stockService.getStockRepository().getNewComicStock();
        model.addAttribute("featuredStock", featuredStock);
        model.addAttribute("specialStock", specialStock);
        model.addAttribute("topStock", topStock);
        model.addAttribute("newStock", newStock);
        return "home";
    }

    // Returns a REST request value
    /*@RequestMapping(value = "/home/api", method = RequestMethod.GET)
    public @ResponseBody String getHomeRest(Model model) {
        Issues firstIssue = issueService.getIssueByID(2);
        model.addAttribute("firstIssue", firstIssue);
        return "home";
    }*/

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String Logout(HttpServletRequest request, HttpServletResponse response, Model model)
//    {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "/home";
//    }
}
