package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.StockInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin.gouws - Created on 2017/01/18.
 */
public class StockRepository extends RepositoryImplementation<Integer, Stock> implements StockInterface {

    public ArrayList<Stock> getFeaturedComicsStock() {
        Query featuredStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "WHERE s.availableQty > 0 AND s.condition = 'Very Fine' " +
                        "ORDER BY s.price DESC")
                .setMaxResults(4);

        return (ArrayList<Stock>) featuredStockQuery.getResultList();
    }

    public ArrayList<Stock> getSpecialsComicStock() {
        Query specialsStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "WHERE s.availableQty > 0 AND s.price > 10 " +
                        "ORDER BY s.price")
                .setMaxResults(4);

        return (ArrayList<Stock>) specialsStockQuery.getResultList();
    }

    public ArrayList<Stock> getTopSellingComicStock() {
        Query topSellerStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "INNER JOIN OrderDetails od ON s.id = od.stockByStockId.id " +
                        "INNER JOIN Issues i ON s.issuesByIssueId.id = i.id " +
                        "GROUP BY s.id, s.issuesByIssueId.id, s.condition, s.availableQty, s.price " +
                        "ORDER BY SUM(od.detailQuantity) DESC")
                .setMaxResults(4);

        return (ArrayList<Stock>) topSellerStockQuery.getResultList();
    }

    public ArrayList<Stock> getNewComicStock() {
        Query newStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "INNER JOIN Issues i ON i.id = s.issuesByIssueId.id " +
                        "ORDER BY i.publicationDate DESC")
                .setMaxResults(4);

        return (ArrayList<Stock>) newStockQuery.getResultList();
    }

    public Stock getComicStock(int issueID, String condition) {
        Query comicStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "WHERE s.issuesByIssueId.id = :issueID AND s.condition = :condition")
                .setParameter("issueID", issueID)
                .setParameter("condition", condition);

        return (Stock) comicStockQuery.getSingleResult();
    }

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
