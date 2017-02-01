package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.services.IssueService;
import za.co.entelect.bootcamp.flash.services.StockService;

import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    private IssueService issueService;
    private StockService stockService;

    @Autowired
    public HomeController(IssueService issueService, StockService stockService) {
        this.issueService = issueService;
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        /*Issues firstIssue = issueService.getIssueRepository().read(2);
        Stock cheapestStock = stockService.getStockRepository().getStockByIssueIDByPrice(2).get(0);
        model.addAttribute("firstIssueImageURL", firstIssue.getImageURL());
        model.addAttribute("firstIssueTitle", firstIssue.getTitle());
        model.addAttribute("firstIssueSeries", firstIssue.getSeriesNumber());
        model.addAttribute("cheapestStockPrice", cheapestStock.getPrice());
        ArrayList<Issues> featuredIssues = (ArrayList<Issues>) issueService.getIssueRepository().getFourFeaturedIssues();
        ArrayList<Issues> specialIssues = (ArrayList<Issues>) issueService.getIssueRepository().getFourIssueSpecials();
        ArrayList<Issues> topSellerIssues = (ArrayList<Issues>) issueService.getIssueRepository().getFourTopSellers();
        ArrayList<Issues> newStockIssues = (ArrayList<Issues>) issueService.getIssueRepository().getFourNewReleases();
        model.addAttribute("featuredIssues", featuredIssues);
        model.addAttribute("specialIssues", specialIssues);
        model.addAttribute("topSellerIssues", topSellerIssues);
        model.addAttribute("newStockIssues", newStockIssues);*/
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
}
