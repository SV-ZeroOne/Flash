package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by steve.velcev on 2017/01/18.
 */

@Embeddable
public class ComicCreatorsPK implements Serializable{

    @Column(name = "IssueID")
    private int issueID;
    @Column(name = "CreatorID")
    private int creatorID;

    public ComicCreatorsPK(){

    }

    public ComicCreatorsPK(int issueID, int creatorID){
        this.issueID = issueID;
        this.creatorID = creatorID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComicCreatorsPK)) return false;
        if(o == null) return false;
        ComicCreatorsPK pk = (ComicCreatorsPK) o;
        return pk.issueID == issueID && pk.creatorID == creatorID;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
