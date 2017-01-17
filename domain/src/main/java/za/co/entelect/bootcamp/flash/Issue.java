package za.co.entelect.bootcamp.flash;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class Issue implements Entity<Integer>{

    private ArrayList<Stock> stock = new ArrayList<Stock>();

    private int issueID;
    private String issueTitle;
    private Date publicationDate;
    private String publisher;
    private short seriesNumber;
    private String description;

    public Issue () {}

    public Issue(int issueID, String issueTitle, Date publicationDate, String publisher, short seriesNumber,
                 String description) {
        this.issueID = issueID;
        this.issueTitle = issueTitle;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.seriesNumber = seriesNumber;
        this.description = description;
    }

    public Integer getID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(short seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueID=" + issueID +
                ", issueTitle='" + issueTitle + '\'' +
                ", publicationDate=" + publicationDate +
                ", publisher='" + publisher + '\'' +
                ", seriesNumber=" + seriesNumber +
                ", description='" + description + '\'' +
                '}';
    }

    public ArrayList<Stock> getStock() {
        return stock;
    }

    public void addToStock(String condition, short quantity, float price)
    {
        Stock stockItem = new Stock(this.getID(), this.getID(), condition, quantity,price);
        stock.add(stockItem);
    }

    public void setStock(ArrayList<Stock> stock) {
        this.stock = stock;
    }

}
