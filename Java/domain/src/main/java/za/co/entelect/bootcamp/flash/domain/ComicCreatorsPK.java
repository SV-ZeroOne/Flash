package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
public class ComicCreatorsPK implements Serializable {
    private int issueId;
    private int creatorId;

    @Column(name = "IssueID", nullable = false)
    @Id
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Column(name = "CreatorID", nullable = false)
    @Id
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComicCreatorsPK that = (ComicCreatorsPK) o;

        if (issueId != that.issueId) return false;
        if (creatorId != that.creatorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = issueId;
        result = 31 * result + creatorId;
        return result;
    }
}
