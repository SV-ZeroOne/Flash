package za.co.entelect.bootcamp.flash.domain;

/**
 * Created by byron.dinkelmann on 2017/01/13.
 */
public class Supplier implements Entity<Integer> {

    private int supplierID;
    private String name;
    private String city;
    private String referenceNumber;

    public Supplier() {}

    public Supplier(int supplierID, String name, String city, String referenceNumber) {
        this.supplierID = supplierID;
        this.name = name;
        this.city = city;
        this.referenceNumber = referenceNumber;
    }

    public Integer getID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                '}';
    }
}