package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

/**
 * Created by byron.dinkelmann on 2017/01/13.
 */
@Entity
@Table(name = "Suppliers")
@NamedQueries({
        @NamedQuery(name = "Supplier.findAll", query = "SELECT e FROM Supplier e")
})
public class Supplier implements Entities<Integer> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID", nullable = false)
    private int supplierID;
    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;
    @Column(name = "ReferenceNumber")
    private String referenceNumber;

//   @OneToOne(targetEntity=Order.class)
//   private Order order;

    @OneToMany(targetEntity=SupplierQuote.class )
    @JoinColumn(name = "SupplierID")
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

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public List getSupplierQuotes() {
        return SupplierQuotes;
    }

    public void setSupplierQuotes(List supplierQuotes) {
        SupplierQuotes = supplierQuotes;
    }
}
