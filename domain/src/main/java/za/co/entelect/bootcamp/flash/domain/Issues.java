package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class Issues implements EntityInterface<Integer> {
    private int issueId;
    private String title;
    private Date publicationDate;
    private String publisher;
    private Short seriesNumber;
    private String description;
    private String imageURL;

    @Id
    @Column(name = "IssueID", nullable = false)
    public Integer getID() {
        return this.issueId;
    }

    public void setID(Integer entityKey) {
        this.issueId = entityKey;
    }

    @Basic
    @Column(name = "Title", nullable = true, length = 500)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PublicationDate", nullable = true)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Basic
    @Column(name = "Publisher", nullable = true, length = 50)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "SeriesNumber", nullable = true)
    public Short getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(Short seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ImageURL", nullable = true, length = 300)
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String image) {
        this.imageURL = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issues issues = (Issues) o;

        if (issueId != issues.issueId) return false;
        if (title != null ? !title.equals(issues.title) : issues.title != null) return false;
        if (publicationDate != null ? !publicationDate.equals(issues.publicationDate) : issues.publicationDate != null)
            return false;
        if (publisher != null ? !publisher.equals(issues.publisher) : issues.publisher != null) return false;
        if (seriesNumber != null ? !seriesNumber.equals(issues.seriesNumber) : issues.seriesNumber != null)
            return false;
        if (description != null ? !description.equals(issues.description) : issues.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = issueId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (seriesNumber != null ? seriesNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
