package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.services.StockService;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */

@Controller
public class ProductController {
    private StockService stockService;

    public ProductController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/issue", method = RequestMethod.GET)
    public String getProductPage(@RequestParam int id,
                                 @RequestParam String condition,
                                 ModelMap model) {
        Stock comicStock = stockService.getStockRepository().getComicStock(id, condition);
        model.addAttribute("comicStock", comicStock);
        return "product";
    }
}
