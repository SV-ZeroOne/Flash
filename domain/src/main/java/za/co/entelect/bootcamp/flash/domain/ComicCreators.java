package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by steve.velcev on 2017/01/13.
 */

@Entity
@Table(name = "ComicCreators")
public class ComicCreators {

    @Column(name = "IssueID")
    private int issueID;
    @Column(name = "CreatorID")
    private int creatorID;
    @Column(name = "CreatorRole")
    private String creatorRole;

    public ComicCreators() {}

    public ComicCreators(int issueID, int creatorID, String creatorRole){
        this.issueID = issueID;
        this.creatorID = creatorID;
        this.creatorRole = creatorRole;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public String getCreatorRole() {
        return creatorRole;
    }

    public void setCreatorRole(String creatorRole) {
        this.creatorRole = creatorRole;
    }

    @Override
    public String toString() {
        return "ComicCreators{" +
                "issueID=" + issueID +
                ", creatorID=" + creatorID +
                ", creatorRole='" + creatorRole + '\'' +
                '}';
    }
}
