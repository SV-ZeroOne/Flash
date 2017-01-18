package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
@javax.persistence.Entity
@Table(name = "Issues")
public class Issue implements Entity<Integer> {

    private ArrayList<Stock> stock = new ArrayList<Stock>();

    @Id @GeneratedValue
    @Column(name = "IssueID", nullable = false)
    private int issueID;
    @Column(name = "Title")
    private String title;
    @Column(name = "PublicationDate")
    private Date publicationDate;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "SeriesNumber")
    private short seriesNumber;
    @Column(name = "Description")
    private String description;

    public Issue () {}

    public Issue(int issueID, String issueTitle, Date publicationDate, String publisher, short seriesNumber,
                 String description) {
        this.issueID = issueID;
        this.title = issueTitle;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.seriesNumber = seriesNumber;
        this.description = description;
    }

    public Integer getID() {
        return issueID;
    }

    public void setID(Integer entityKey) {
        this.issueID = entityKey;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String issueTitle) {
        this.title = issueTitle;
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
                ", issueTitle='" + title + '\'' +
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
