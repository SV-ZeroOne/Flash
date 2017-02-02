
package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kevin.gouws on 2017/01/18.
 */
public class StockRepository extends RepositoryImplementation<Integer, Stock> implements StockInterface {

    public List<Stock> getNextStockSet(int start, int end)
    {
        Query stockQuery = entityManager
                .createQuery("SELECT s FROM Stock AS s"
                        +" WHERE s.issuesByIssueId.id BETWEEN "+start+ " AND "+ (end-1));
        return stockQuery.getResultList();

    }
    public List<Stock> getFilterList(String filter)
    {
        if(filter.equals("Title AZ"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"
                            +" ORDER BY s.issuesByIssueId.title ASC");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Title ZA"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s " + "FROM Stock AS s"
                            +" ORDER BY s.issuesByIssueId.title DESC ");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Publisher DC"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s " + "FROM Stock AS s"
                            +" WHERE s.issuesByIssueId.publisher = 'DC'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Publisher Darkhorse"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s " + "FROM Stock AS s"
                            +" WHERE s.issuesByIssueId.publisher = 'Darkhorse'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Condition Very Fine"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Very Fine'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Condition Fine"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Fine'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Condition Average"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Average'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("Condition Poor"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Poor'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("priceHigh"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Very Fine'");
            return stockQuery.getResultList();
        }
        else if(filter.equals("priceLow"))
        {
            Query stockQuery = entityManager
                    .createQuery("SELECT s FROM Stock AS s"+
                            " WHERE s.condition = 'Poor'");
            return stockQuery.getResultList();
        }

        Query stockQuery = entityManager
                .createQuery("SELECT s " + "FROM Stock AS s"
                        +" WHERE s.issuesByIssueId.id BETWEEN "+0+ " AND "+ (20-1));
        return stockQuery.getResultList();
    }
}