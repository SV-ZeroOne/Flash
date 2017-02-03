package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementations.StockRepository;
import za.co.entelect.bootcamp.flash.domain.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockRepository getStockRepository() {
        return stockRepository;
    }

}
