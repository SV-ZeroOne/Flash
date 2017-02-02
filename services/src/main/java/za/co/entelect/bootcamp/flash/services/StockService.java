package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementations.StockRepository;
import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.Implementation.StockRepository;

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

    public List<Stock> getNextStockSet(int start, int end)
    {
        return stockRepository.getNextStockSet(start, end);
    }

    public List<Stock> getFilterList(String filter)
    {
        return stockRepository.getFilterList(filter);
    }

    public List<Stock> getNext(List<Stock> inList, int start, int end)
    {
        List<Stock> stockSet = new ArrayList<Stock>();
        for (int stock = start; stock < end; stock++)
        {
            if(stock < inList.size() && end >= 0) {
                stockSet.add(inList.get(stock));
            }
        }
        return stockSet;
    }
}
