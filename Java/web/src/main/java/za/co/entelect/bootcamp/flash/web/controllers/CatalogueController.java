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
    public String catalogueView(@RequestParam(required = false, value = "page") Integer inPage, @RequestParam("filter") String inFilter, Model model) {
        if (inPage == null) {
            inPage = 1;
        }
        if (inPage <= 0) {
            inPage = 1;
        }

        currentPage = inPage;
        int start = ((inPage * displayAmount)) - displayAmount;
        int end = inPage * displayAmount;

        if (!inFilter.equals("All")) {
            displayList = stockService.getStockRepository().getFilterList(inFilter, start, end);
            displaySize = displayList.size();

            model.addAttribute("stockList", displayList);
            model.addAttribute("page", currentPage);
            model.addAttribute("filter", inFilter);
            model.addAttribute("displaySize",displaySize);
            if(displaySize<=0)
            {
                return "error";
            }

            return "catalogue";
        }

        displayList = stockService.getStockRepository().getNextStockSet(start, end);
        displaySize = displayList.size();
        model.addAttribute("stockList", displayList);
        model.addAttribute("page", currentPage);
        model.addAttribute("filter", inFilter);
        model.addAttribute("displaySize", displaySize);

        if(displaySize<=0)
        {
            return "error";
        }

        return "catalogue";
    }

}


