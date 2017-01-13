package za.co.entelect.bootcamp.flash;

/**
 * Created by steve.velcev on 2017/01/13.
 */
public class Creator {

    private int creatorID;
    private String name;
    private String counteryOfResidence;
    private Byte[] taxReferenceNumber;
    private String emailAddress;

    public Creator(){}

    public Creator(int creatorID, String name, String counteryOfResidence, Byte[] taxReferenceNumber, String emailAddress) {
        this.creatorID = creatorID;
        this.name = name;
        this.counteryOfResidence = counteryOfResidence;
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
        return counteryOfResidence;
    }

    public void setCounteryOfResidence(String counteryOfResidence) {
        this.counteryOfResidence = counteryOfResidence;
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
}
