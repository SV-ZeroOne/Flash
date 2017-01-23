package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
@Entity
@Table(name = "Issues")
public class Issue implements Entities<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IssueID", nullable = false)
    private int issueID;

    @OneToMany(mappedBy = "id.issue")
    private List<ComicCreators> ComicCreators;

    @Column (name ="Title")
    private String issueTitle;

    @Column (name ="PublicationDate")
    private Date publicationDate;

    @Column (name ="Publisher")
    private String publisher;

    @Column (name ="SeriesNumber")
    private short seriesNumber;

    @Column (name ="Description")
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

    public void setID(Integer entityKey) {
        this.issueID = entityKey;
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

    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public List getComicCreators() {
        return ComicCreators;
    }

    public void setComicCreators(List comicCreators) {
        ComicCreators = comicCreators;
    }
}
