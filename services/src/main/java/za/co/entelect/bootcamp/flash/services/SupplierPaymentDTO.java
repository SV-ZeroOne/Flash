package za.co.entelect.bootcamp.flash.services;

import java.math.BigDecimal;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
@Deprecated
public class SupplierPaymentDTO {

        private String supplierRefNumber;
        private String paymentRefNumber;
        private BigDecimal amount;

        public String getSupplierRefNumber() {
            return supplierRefNumber;
        }

        public void setSupplierRefNumber(String supplierRefNumber) {
            this.supplierRefNumber = supplierRefNumber;
        }

        public String getPaymentRefNumber() {
            return paymentRefNumber;
        }

        public void setPaymentRefNumber(String paymentRefNumber) {
            this.paymentRefNumber = paymentRefNumber;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
}
