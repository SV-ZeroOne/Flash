package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.List;

public class IssueRepository extends RepositoryImplementation<Integer, Issues> implements IssueInterface {

//    public List<Issues> getNextIssueSet(int start, int end)
//    {
////        Query issuesQuery = entityManager
////                .createQuery("SELECT st.issuesByIssueId " +
////                        "FROM Stock st " +
////                        "WHERE st.availableQty > 0 AND st.condition = 'Very Fine' " +
////                        "ORDER BY st.price")
////                .setMaxResults(4);
//
//        Query issuesQuery = entityManager
//                .createQuery("SELECT s.issuesByIssueId " + "FROM Stock AS s"
//                +" WHERE s.issuesByIssueId.ID BETWEEN "+start+ " AND "+ (end-1));
//        return issuesQuery.getResultList();
//
//    }
//    public List<Issues> getFilterList(String filter)
//    {
//        if(filter.equals("Title A-Z"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT i " + "FROM Issues AS i"
//                            +" ORDER BY i.title ASC");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Title Z-A"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT i " + "FROM Issues AS i"
//                            +" ORDER BY i.title DESC ");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Publisher DC"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT i " + "FROM Issues AS i"
//                            +" WHERE i.publisher = 'DC'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Publisher Darkhorse"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT i " + "FROM Issues AS i"
//                            +" WHERE i.publisher = 'Darkhorse'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Condition Very Fine"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT s.issuesByIssueId FROM Stock AS s"+
//                            " WHERE s.condition = 'Very Fine'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Condition Fine"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT s.issuesByIssueId FROM Stock AS s"+
//                            " WHERE s.condition = 'Fine'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Condition Average"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT s.issuesByIssueId FROM Stock AS s"+
//                            " WHERE s.condition = 'Average'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("Condition Poor"))
//        {
//            Query issuesQuery = entityManager
//                    .createQuery("SELECT s.issuesByIssueId FROM Stock AS s"+
//                            " WHERE s.condition = 'Poor'");
//            return issuesQuery.getResultList();
//        }
//        else if(filter.equals("priceHigh"))
//        {
//        }
//        else if(filter.equals("priceLow"))
//        {}
//
//        Query issuesQuery = entityManager
//                .createQuery("SELECT s.issuesByIssueId " + "FROM Stock AS s"
//                        +" WHERE s.issuesByIssueId.ID BETWEEN "+0+ " AND "+ (20-1));
//        return issuesQuery.getResultList();
//    }

}
