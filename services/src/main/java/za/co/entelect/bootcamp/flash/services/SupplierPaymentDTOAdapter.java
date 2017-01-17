package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Supplier;
import za.co.entelect.bootcamp.flash.domain.SupplierPayment;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
public class SupplierPaymentDTOAdapter extends SupplierPaymentDTO implements Adapter{

    private Supplier supplier;
    private SupplierPayment supplierPayment;


    public SupplierPaymentDTOAdapter(Supplier supplier, SupplierPayment suppPayment){
        this.supplier = supplier;
        this.supplierPayment = suppPayment;
    }

    @Override
    public String getSupplierRefNumber() {
        return supplier.getReferenceNumber();
    }

    @Override
    public void setSupplierRefNumber(String supplierRefNumber) {
        super.setSupplierRefNumber(supplierRefNumber);
    }

    @Override
    public String getPaymentRefNumber() {
        return String.valueOf(supplierPayment.getPaymentID());
    }

    @Override
    public void setPaymentRefNumber(String paymentRefNumber) {
        super.setPaymentRefNumber(paymentRefNumber);
    }

    @Override
    public double getAmount() {
        return supplierPayment.getTotal();
    }

    @Override
    public void setAmount(double amount) {
        super.setAmount(amount);
    }
}

