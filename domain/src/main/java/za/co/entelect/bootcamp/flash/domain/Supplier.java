package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

/**
 * Created by byron.dinkelmann on 2017/01/13.
 */
@javax.persistence.Entity
@Table(name = "Suppliers")
public class Supplier implements Entities<Integer> {

    @Id @GeneratedValue
    @Column(name = "SupplierID", nullable = false)
    private int supplierID;
    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;
    @Column(name = "ReferenceNumber")
    private String referenceNumber;

    @OneToMany(targetEntity=Order.class)
    private List Orders;

    @OneToMany(targetEntity=SupplierQuote.class )
    private List SupplierQuotes;

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

    public void setID(Integer entityKey) {
        this.supplierID = entityKey;
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

    public List getOrders() {
        return Orders;
    }

    public void setOrders(List orders) {
        Orders = orders;
    }

    public List getSupplierQuotes() {
        return SupplierQuotes;
    }

    public void setSupplierQuotes(List supplierQuotes) {
        SupplierQuotes = supplierQuotes;
    }
}
