package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by steve.velcev on 2017/01/18.
 */

@Embeddable
public class ComicCreatorsPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "IssueID")
    private Issue issue;
    @ManyToOne
    @JoinColumn(name = "CreatorID")
    private Creator creator;

    public ComicCreatorsPK(){

    }

    public ComicCreatorsPK(Issue issue, Creator creator){
        this.issue = issue;
        this.creator = creator;
    }

    public Issue getIssueID() {
        return issue;
    }

    public void setIssueID(int issueID) {
        this.issue = issue;
    }

    public Creator getCreatorID() {
        return creator;
    }

    public void setCreatorID(int creatorID) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComicCreatorsPK)) return false;
        if(o == null) return false;
        ComicCreatorsPK pk = (ComicCreatorsPK) o;
        return pk.issue == issue && pk.creator == creator;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Creator getCreator() {
        return this.creator;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Issue getIssue() {
        return this.issue;
    }
}
