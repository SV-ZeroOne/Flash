package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.List;

public class IssueRepository extends RepositoryImplementation<Integer, Issues> implements IssueInterface {

    public List<Issues> getFourFeaturedIssues() {
        Query featuredIssuesQuery = entityManager
                .createQuery("SELECT st.issuesByIssueId " +
                        "FROM Stock st " +
                        "WHERE st.availableQty > 0 AND st.condition = 'Very Fine' " +
                        "ORDER BY st.price")
                .setMaxResults(4);

        return featuredIssuesQuery.getResultList();
    }

    public List<Issues> getFourIssueSpecials() {
        Query issueSpecialsQuery = entityManager
                .createQuery("SELECT st.issuesByIssueId " +
                        "FROM Stock st " +
                        "WHERE st.availableQty > 0 AND st.price > 10 " +
                        "ORDER BY st.price")
                .setMaxResults(4);

        return issueSpecialsQuery.getResultList();
    }

    public List<Issues> getFourTopSellers() {
        Query topSellerQuery = entityManager
                .createQuery("SELECT o.issuesByIssueId " +
                        "FROM Orders o " +
                        "WHERE o.qtyOrdered < 99 " +
                        "ORDER BY o.qtyOrdered DESC")
                .setMaxResults(4);

        return topSellerQuery.getResultList();
    }

    public List<Issues> getFourNewReleases() {
        Query newReleases = entityManager
                .createQuery("SELECT i FROM Issues i ORDER BY i.publicationDate DESC")
                .setMaxResults(4);

        return newReleases.getResultList();
    }
}
