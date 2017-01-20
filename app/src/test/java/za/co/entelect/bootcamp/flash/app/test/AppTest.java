package za.co.entelect.bootcamp.flash.app.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.co.entelect.bootcamp.flash.domain.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class AppTest {

    private Supplier supplier;
    private Issue issue;
    private Issue newIssue = new Issue();
    private Creator newCreator = new Creator();
    private ComicCreators newComicCreators = new ComicCreators();
    private ComicCreatorsPK comicCreatorsPK = new ComicCreatorsPK();
    private List<Creator> creators;
    private List<ComicCreators> comicCreators;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testRetrieveCreators() {
        TypedQuery<Creator> query = entityManager.createNamedQuery("Creator.findAll", Creator.class);
        creators = query.getResultList();

        Assert.assertTrue(creators.size() == 1000);
    }

    @Test
    public void testIfComicCreatorsAdditionGreaterThanOne() {
        //TypedQuery<ComicCreators> query = (TypedQuery<ComicCreators>) entityManager.createQuery();
        Query query = entityManager.createQuery("SELECT c FROM ComicCreators c WHERE c.id.creator.creatorID = 1");
        comicCreators = query.getResultList();
        for (ComicCreators c : comicCreators) {
            System.out.println(c.toString());
        }

        Assert.assertTrue(comicCreators.size()==121);
    }

    @Test
    public void testIssueCreators() {
        Query query = entityManager.createQuery("SELECT i FROM Issue i WHERE i.issueID = 2");
        issue = (Issue) query.getSingleResult();
        List<ComicCreators> comicCreators = issue.getComicCreators();

        Assert.assertTrue(comicCreators.size()==5);
    }

    @Test
    public void testCreateDBEntry() {
        supplier = new Supplier();
        supplier.setCity("Johannesburg");
        supplier.setName("Team Flash");
        supplier.setReferenceNumber("1337420666");

        entityManager.getTransaction().begin();
        entityManager.persist(supplier);
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("SELECT s FROM Supplier s WHERE s.name = 'Team Flash'");
        Supplier testSupplier = (Supplier) query.getSingleResult();

        Assert.assertEquals(testSupplier, supplier);
    }

    @Test
    public void testUpdateDBEntry() {
        Query query = entityManager.createQuery("SELECT s FROM Supplier s WHERE s.name = 'Team Flash'");
        Supplier testSupplier = (Supplier) query.getSingleResult();
        testSupplier.setCity("JHB");

        entityManager.getTransaction().begin();
        entityManager.merge(testSupplier);
        entityManager.getTransaction().commit();

        Query query2 = entityManager.createQuery("SELECT s FROM Supplier s WHERE s.name = 'Team Flash'");
        Supplier testSupplier2 = (Supplier) query2.getSingleResult();

        Assert.assertTrue(testSupplier2.getCity().equals("JHB"));
    }

    @Test
    public void testDeleteDBEntry() {
        //TODO
        Query query = entityManager.createQuery("SELECT s FROM Supplier s WHERE s.name = 'Team Flash'");
        Supplier testSupplier = (Supplier) query.getSingleResult();
        int testSuppID = testSupplier.getID();

        entityManager.getTransaction().begin();
        entityManager.remove(testSupplier);
        entityManager.getTransaction().commit();

        Query query2 = entityManager.createQuery("SELECT s FROM Supplier s WHERE s.supplierID = :testSuppID")
                .setParameter("testSuppID", testSuppID);
        Supplier testSupplier2 = (Supplier) query2.getSingleResult();

        //Assert.assertTrue(testSupplier2 == null);
    }

    @Test
    public void testNewInsertionRelationship() {
        newIssue.setSeriesNumber((short) 21);
        newIssue.setIssueTitle("The Incredible Team Flash's Adventure");
        newIssue.setPublisher("Entelect");
        newIssue.setDescription("Most Awesome Comic EVARRR!!!!");
        newIssue.setPublicationDate(new Date(20171230));

        newCreator.setName("Team Flash");
        newCreator.setCounteryOfResidence("South Africa");
        newCreator.setEmailAddress("team.flash@entelect.co.za");
        newCreator.setTaxReferenceNumber(new Byte[]{1, 2, 3, 4});

        entityManager.getTransaction().begin();
        entityManager.persist(newIssue);
        entityManager.persist(newCreator);
        entityManager.getTransaction().commit();

        Query issueQ = entityManager.createQuery("SELECT i FROM Issue i WHERE i.publisher = 'Entelect'");
        Issue theIssue = (Issue) issueQ.getSingleResult();

        Query creatorQ = entityManager.createQuery("SELECT c FROM Creator c WHERE c.name = 'Team Flash'");
        Creator theCreator = (Creator) creatorQ.getSingleResult();

        System.out.println("CREATOR ID: " + theCreator.getID());
        System.out.println("Issue ID: " + theIssue.getID());

        comicCreatorsPK.setCreator(theCreator);
        comicCreatorsPK.setIssue(theIssue);

        newComicCreators.setCreatorRole("Asshole");
        newComicCreators.setId(comicCreatorsPK);

        entityManager.getTransaction().begin();
        entityManager.persist(newComicCreators);
        entityManager.getTransaction().commit();

    }

    @After
    public void tearDown() {
        entityManager.remove(newComicCreators);
        entityManager.remove(newIssue);
        entityManager.remove(newCreator);
    }
}
