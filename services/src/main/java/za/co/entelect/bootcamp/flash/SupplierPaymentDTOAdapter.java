package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPaymentDTOAdapter {

    private Supplier supplier;
    private SupplierPayment supplierPayment;


    public SupplierPaymentDTOAdapter(Supplier supplier, SupplierPayment suppPayment){
        this.supplier = supplier;
        this.supplierPayment = suppPayment;
        createSupplierPaymentDTO();
    }

    private PaymentService.SupplierPaymentDTO createSupplierPaymentDTO() {
        PaymentService.SupplierPaymentDTO dto = new PaymentService.SupplierPaymentDTO();
        dto.setSupplierRefNumber(supplier.getReferenceNumber());
        dto.setPaymentRefNumber(String.valueOf(supplierPayment.getPaymentID()));
        dto.setAmount(supplierPayment.getTotal());
        return dto;
    }
}
