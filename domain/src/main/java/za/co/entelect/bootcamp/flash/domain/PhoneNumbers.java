package za.co.entelect.bootcamp.flash.domain;

import org.hibernate.validator.constraints.NotEmpty;
import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class PhoneNumbers implements EntityInterface<Integer> {
    private int phoneNumberId;

    @NotEmpty(message = "Please enter in a phone number")
    private String phoneNumber;

    private String type;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "PhoneNumberID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return this.phoneNumberId;
    }

    public void setID(Integer entityKey) {
        this.phoneNumberId = entityKey;
    }

    @Basic
    @Column(name = "PhoneNumber", nullable = false, length = 10)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumbers that = (PhoneNumbers) o;

        if (phoneNumberId != that.phoneNumberId) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneNumberId;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
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
