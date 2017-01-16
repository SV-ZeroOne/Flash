package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPaymentDTOAdapterFactory {

    Adapter createSupplierPaymentDTOAdapterFactory(Supplier supplier, SupplierPayment suppPayment){
        return new SupplierPaymentDTOAdapter(supplier,suppPayment);
    }
}
