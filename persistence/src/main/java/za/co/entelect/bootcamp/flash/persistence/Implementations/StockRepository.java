package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.StockInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.ArrayList;

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
        /*  SELECT TOP(4) s.IssueID, i.Title, i.ImageURL, SUM(od.DetailQuantity) AS TotalOrderQty
            FROM OrderDetails AS od
            INNER JOIN Stock AS s ON od.StockReferenceID = s.StockReferenceID
            INNER JOIN Issues AS i ON s.IssueID = i.IssueID
            GROUP BY s.IssueID, i.Title, i.ImageURL
            ORDER BY  TotalOrderQty DESC; */

        Query topSellerStockQuery = entityManager
                .createQuery("SELECT s " +
                        "FROM Stock s " +
                        "INNER JOIN Issues i ON s.issuesByIssueId.id = i.id " +
                        "INNER JOIN Orders o ON i.id = o.issuesByIssueId.id " +
                        "WHERE o.qtyOrdered < 99 " +
                        "ORDER BY o.qtyOrdered DESC")
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
}
