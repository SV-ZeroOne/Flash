package za.co.entelect.bootcamp.flash.domain;

import java.util.Arrays;

/**
 * Created by steve.velcev on 2017/01/13.
 */
public class Creator {

    private int creatorID;
    private String name;
    private String countryOfResidence;
    private Byte[] taxReferenceNumber;
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
