package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Supplier;
import za.co.entelect.bootcamp.flash.domain.SupplierPayment;

import java.math.BigDecimal;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
@Deprecated
public class SupplierPaymentDTOAdapter extends SupplierPaymentDTO {

    private Supplier supplier;
    private SupplierPayment supplierPayment;


    public SupplierPaymentDTOAdapter(Supplier supplier, SupplierPayment suppPayment){
        this.supplier = supplier;
        this.supplierPayment = suppPayment;
    }

    @Override
    public String getSupplierRefNumber() {
        return this.supplier.getReferenceNumber();
    }

    @Override
    public void setSupplierRefNumber(String supplierRefNumber) {
        super.setSupplierRefNumber(supplierRefNumber);
    }

    @Override
    public String getPaymentRefNumber() {
        return String.valueOf(this.supplierPayment.getID());
    }

    @Override
    public void setPaymentRefNumber(String paymentRefNumber) {
        super.setPaymentRefNumber(paymentRefNumber);
    }

    @Override
    public BigDecimal getAmount() {
        return this.supplierPayment.getTotal();
    }

    @Override
    public void setAmount(BigDecimal amount) {
        super.setAmount(amount);
    }

}

