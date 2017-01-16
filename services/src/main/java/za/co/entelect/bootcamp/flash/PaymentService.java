package za.co.entelect.bootcamp.flash;

public interface PaymentService {
    public String makePayment(SupplierPaymentDTO supplierPayment);

    public class SupplierPaymentDTO {
        private String supplierRefNumber;
        private String paymentRefNumber;
        private double amount;

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

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}

