package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import za.co.entelect.bootcamp.flash.domain.Stock;

import za.co.entelect.bootcamp.flash.services.StockService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byron.dinkelmann on 2017/01/31.
 */
@Controller
public class CatalogueController {

    private List<Stock> displayList = new ArrayList<Stock>();
    private int displayAmount = 20;
    private int currentPage = 1;
    private int displaySize = 0;
    private StockService stockService;


    @Autowired
    public CatalogueController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/catalogue", method = RequestMethod.GET)
    public String catalogueView(@RequestParam("page") int inPage,@RequestParam("filter") String inFilter, Model model) {

        //displayList = new ArrayList<Stock>();
        if(inPage <= 0)
        {
            inPage = 1;
        }

        currentPage = inPage;
        int start = (inPage*displayAmount) - displayAmount;
        int end = inPage*displayAmount;

        if(!inFilter.equals("All"))
        {
            List<Stock> displayFilterList = stockService.getFilterList(inFilter);
            //displayList = stockService.getFilterList(inFilter);
           // displayList = stockService.getNext(displayList,start,end);
            displaySize = displayFilterList.size();

            model.addAttribute("stockList",stockService.getNext(displayFilterList,start,end).toArray());
            model.addAttribute("page", currentPage);
            model.addAttribute("filter", inFilter);
            model.addAttribute("displaySize", Math.ceil(displaySize/displayAmount));

            return "catalogue";
        }

        displayList = stockService.getNextStockSet(start,end);
        displaySize = displayList.size();
        model.addAttribute("stockList",displayList.toArray());
        model.addAttribute("page", currentPage);
        model.addAttribute("filter", inFilter);
        model.addAttribute("displaySize", displaySize);
        return "catalogue";
    }

}


