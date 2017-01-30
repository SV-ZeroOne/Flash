package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class Suppliers implements EntityInterface<Integer> {
    private int supplierId;
    private String name;
    private String city;
    private String referenceNumber;

    @Id
    @Column(name = "SupplierID", nullable = false)
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "ReferenceNumber", nullable = true, length = 25)
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suppliers suppliers = (Suppliers) o;

        if (supplierId != suppliers.supplierId) return false;
        if (name != null ? !name.equals(suppliers.name) : suppliers.name != null) return false;
        if (city != null ? !city.equals(suppliers.city) : suppliers.city != null) return false;
        if (referenceNumber != null ? !referenceNumber.equals(suppliers.referenceNumber) : suppliers.referenceNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (referenceNumber != null ? referenceNumber.hashCode() : 0);
        return result;
    }

    public Integer getID() {
        return this.supplierId;
    }

    public void setID(Integer entityKey) {
        this.supplierId = entityKey;
    }
}
