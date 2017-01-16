package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
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
