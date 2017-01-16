package za.co.entelect.bootcamp.flash;

public interface SupplierService {
    public String placeOrder(IssueOrderDTO issueOrder, String supplierRefNumber, int quantity);

    public class IssueOrderDTO {
        private int issueID;
        private String seriesNumber;
        private int quantity;

        public int getIssueID() {
            return issueID;
        }

        public void setIssueID(int issueID) {
            this.issueID = issueID;
        }

        public String getSeriesNumber() {
            return seriesNumber;
        }

        public void setSeriesNumber(String seriesNumber) {
            this.seriesNumber = seriesNumber;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

}

