package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPaymentDTOAdapterFactory implements AbstractFactory{
    private Supplier supplier;
    private SupplierPayment supplierPayment;

    public SupplierPaymentDTOAdapterFactory(Supplier supplier, SupplierPayment supplierPayment) {
        this.supplier = supplier;
        this.supplierPayment = supplierPayment;
    }

    public SupplierPaymentDTOAdapter createAdapter()
    {
        return new SupplierPaymentDTOAdapter(supplier,supplierPayment);
    }
}
