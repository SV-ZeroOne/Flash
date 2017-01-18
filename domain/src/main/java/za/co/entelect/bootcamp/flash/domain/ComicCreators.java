package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by steve.velcev on 2017/01/13.
 */

@Entity
@Table
public class ComicCreators {

    @EmbeddedId
    private ComicCreatorsPK id;

    @Column(name = "CreatorRole")
    private String creatorRole;

    public ComicCreators() {}

    public ComicCreators(ComicCreatorsPK id, String creatorRole){
        this.id = id;
        this.creatorRole = creatorRole;
    }

    public ComicCreatorsPK getId() {
        return id;
    }

    public void setId(ComicCreatorsPK id) {
        this.id = id;
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
                "issueID=" + id.getIssueID() +
                ", creatorID=" + id.getCreatorID() +
                ", creatorRole='" + creatorRole + '\'' +
                '}';
    }
}
