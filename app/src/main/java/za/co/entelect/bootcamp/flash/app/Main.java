package za.co.entelect.bootcamp.flash.app;

import za.co.entelect.bootcamp.flash.domain.Supplier;
import za.co.entelect.bootcamp.flash.services.StockOrderPlacement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Application Executed.");
        StockOrderPlacement stockOrderPlacement;

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );
//        Supplier newSupplier = new Supplier();
//        newSupplier.setName("Steve Jobs");
//        newSupplier.setCity("Johannesburg");
//        newSupplier.setReferenceNumber("420DoesthisWork");
//
//        entitymanager.persist(newSupplier);
        TypedQuery<Supplier> query = entitymanager.createNamedQuery("Supplier.findAll", Supplier.class);
        List<Supplier> results = query.getResultList();
        for (Supplier s: results) {
            System.out.println(s.toString());
        }

        entitymanager.getTransaction( ).commit( );
        //entitymanager.getTransaction().rollback();
        entitymanager.close( );
        emfactory.close( );
    }

}
