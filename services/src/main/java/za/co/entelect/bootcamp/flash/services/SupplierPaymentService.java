package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.SupplierPaymentRepository;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class SupplierPaymentService {

    private SupplierPaymentRepository supplierPaymentRepository;

    public SupplierPaymentService(SupplierPaymentRepository supplierPaymentRepository) {
        this.supplierPaymentRepository = supplierPaymentRepository;
    }
}
