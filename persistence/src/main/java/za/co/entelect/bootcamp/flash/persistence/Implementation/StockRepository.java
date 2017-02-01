package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * @author kevin.gouws - Created on 2017/01/18.
 */
public class StockRepository extends RepositoryImplementation<Integer, Stock> implements StockInterface {
    public ArrayList<Stock> getStockByIssueIDByPrice(int id) {
        Query issueQuery = entityManager
                .createQuery("SELECT s FROM Stock s WHERE s.issuesByIssueId.id = :id ORDER BY s.price")
                .setParameter("id", id);
        return (ArrayList<Stock>) issueQuery.getResultList();
    }
}
