package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementations.SupplierQuoteRepository;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class SupplierQuoteService {

    private SupplierQuoteRepository supplierQuoteRepository;

    public SupplierQuoteService(SupplierQuoteRepository supplierQuoteRepository) {
        this.supplierQuoteRepository = supplierQuoteRepository;
    }
}
