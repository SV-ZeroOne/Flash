package za.co.entelect.bootcamp.flash.domain;

import javax.persistence.*;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class CustomerAddress implements EntityInterface<Integer> {
    private int customerAddressId;
    private String address1;
    private String address2;
    private String suburb;
    private String city;
    private String postalCode;
    private String addressType;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "CustomerAddressID", nullable = false)
    public Integer getID() {
        return this.customerAddressId;
    }

    public void setID(Integer entityKey) {
        this.customerAddressId = entityKey;
    }

    @Basic
    @Column(name = "Address1", nullable = false, length = 100)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "Address2", nullable = true, length = 100)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "Suburb", nullable = true, length = 100)
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "PostalCode", nullable = true, length = 4)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "AddressType", nullable = true, length = 20)
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (customerAddressId != that.customerAddressId) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (suburb != null ? !suburb.equals(that.suburb) : that.suburb != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (addressType != null ? !addressType.equals(that.addressType) : that.addressType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerAddressId;
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (addressType != null ? addressType.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    public CustomerAccounts getCustomerAccountsByCustomerId() {
        return customerAccountsByCustomerId;
    }

    public void setCustomerAccountsByCustomerId(CustomerAccounts customerAccountsByCustomerId) {
        this.customerAccountsByCustomerId = customerAccountsByCustomerId;
    }
}
