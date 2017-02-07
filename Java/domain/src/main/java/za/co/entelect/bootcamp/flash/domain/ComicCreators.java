package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
@IdClass(ComicCreatorsPK.class)
public class ComicCreators {
    private int issueId;
    private int creatorId;
    private String creatorRole;

    @Id
    @Column(name = "IssueID", nullable = false)
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Id
    @Column(name = "CreatorID", nullable = false)
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "CreatorRole", nullable = true, length = 50)
    public String getCreatorRole() {
        return creatorRole;
    }

    public void setCreatorRole(String creatorRole) {
        this.creatorRole = creatorRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComicCreators that = (ComicCreators) o;

        if (issueId != that.issueId) return false;
        if (creatorId != that.creatorId) return false;
        if (creatorRole != null ? !creatorRole.equals(that.creatorRole) : that.creatorRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = issueId;
        result = 31 * result + creatorId;
        result = 31 * result + (creatorRole != null ? creatorRole.hashCode() : 0);
        return result;
    }
}
