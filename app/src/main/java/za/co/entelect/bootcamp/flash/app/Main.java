package za.co.entelect.bootcamp.flash.app;

import za.co.entelect.bootcamp.flash.domain.Supplier;
import za.co.entelect.bootcamp.flash.services.StockOrderPlacement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Application Executed.");
        StockOrderPlacement stockOrderPlacement;

//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
//        EntityManager entitymanager = emfactory.createEntityManager( );
//        entitymanager.getTransaction( ).begin( );
//        Supplier newSupplier = new Supplier();
//        newSupplier.setName("Steve Jobs");
//        newSupplier.setCity("Johannesburg");
//        newSupplier.setReferenceNumber("420DoesthisWork");
//
//        entitymanager.persist(newSupplier);
//
//        entitymanager.getTransaction( ).commit( );
//        entitymanager.close( );
//        emfactory.close( );
    }

}
