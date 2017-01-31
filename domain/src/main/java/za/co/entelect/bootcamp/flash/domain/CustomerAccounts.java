package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Entity
public class CustomerAccounts implements EntityInterface<Integer> {

    private int customerId;
    private String firstName;
    private String surname;
    private byte[] password;

    @Id
    @Column(name = "CustomerID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return this.customerId;
    }

    public void setID(Integer entityKey) {
        this.customerId = entityKey;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Password", nullable = false)
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAccounts that = (CustomerAccounts) o;

        if (customerId != that.customerId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (!Arrays.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }
}
