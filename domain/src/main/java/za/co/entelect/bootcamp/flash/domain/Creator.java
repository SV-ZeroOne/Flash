package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Arrays;

/**
 * Created by steve.velcev on 2017/01/13.
 */

@Entity
@Table(name = "Creators")
public class Creator {

    @Id @GeneratedValue
    @Column(name = "CreatorID", nullable = false)
    @OneToOne(mappedBy="ComicCreators")
    private int creatorID;

    @Column(name = "Name")
    private String name;

    @Column(name = "CountryOfResidence")
    private String countryOfResidence;

    @Column(name = "TaxReferenceNumber")
    private Byte[] taxReferenceNumber;

    @Column(name = "EmailAddress")
    private String emailAddress;

    public Creator() {}

    public Creator(int creatorID, String name, String countryOfResidence,
                   Byte[] taxReferenceNumber, String emailAddress) {
        this.creatorID = creatorID;
        this.name = name;
        this.countryOfResidence = countryOfResidence;
        this.taxReferenceNumber = taxReferenceNumber;
        this.emailAddress = emailAddress;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounteryOfResidence() {
        return countryOfResidence;
    }

    public void setCounteryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public Byte[] getTaxReferenceNumber() {
        return taxReferenceNumber;
    }

    public void setTaxReferenceNumber(Byte[] taxReferenceNumber) {
        this.taxReferenceNumber = taxReferenceNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "creatorID=" + creatorID +
                ", name='" + name + '\'' +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                ", taxReferenceNumber=" + Arrays.toString(taxReferenceNumber) +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
