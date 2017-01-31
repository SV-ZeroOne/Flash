package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class Creators implements EntityInterface<Integer> {
    private int creatorId;
    private String name;
    private String countryOfResidence;
    private byte[] taxReferenceNumber;
    private String emailAddress;

    @Id
    @Column(name = "CreatorID", nullable = false)
    public Integer getID() {
        return this.creatorId;
    }
    /*public int getCreatorId() {
        return creatorId;
    }*/

    public void setID(Integer entityKey) {
        this.creatorId = entityKey;
    }
   /* public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }*/

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CountryOfResidence", nullable = true, length = 25)
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    @Basic
    @Column(name = "TaxReferenceNumber", nullable = true)
    public byte[] getTaxReferenceNumber() {
        return taxReferenceNumber;
    }

    public void setTaxReferenceNumber(byte[] taxReferenceNumber) {
        this.taxReferenceNumber = taxReferenceNumber;
    }

    @Basic
    @Column(name = "EmailAddress", nullable = true, length = 256)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creators creators = (Creators) o;

        if (creatorId != creators.creatorId) return false;
        if (name != null ? !name.equals(creators.name) : creators.name != null) return false;
        if (countryOfResidence != null ? !countryOfResidence.equals(creators.countryOfResidence) : creators.countryOfResidence != null)
            return false;
        if (!Arrays.equals(taxReferenceNumber, creators.taxReferenceNumber)) return false;
        if (emailAddress != null ? !emailAddress.equals(creators.emailAddress) : creators.emailAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creatorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (countryOfResidence != null ? countryOfResidence.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(taxReferenceNumber);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }


}
