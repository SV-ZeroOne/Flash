package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Supplier;
import za.co.entelect.bootcamp.flash.domain.SupplierPayment;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPaymentDTOAdapterFactory {

    public SupplierPaymentDTOAdapter createSupplierPaymentDTOAdapter(Supplier supplier, SupplierPayment supplierPayment) {
        return new SupplierPaymentDTOAdapter(supplier, supplierPayment);
    }
}
