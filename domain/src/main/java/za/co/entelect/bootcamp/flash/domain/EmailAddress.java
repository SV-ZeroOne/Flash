package za.co.entelect.bootcamp.flash.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class EmailAddress implements EntityInterface<Integer> {
    private int emailAddressId;

    @NotEmpty(message = "Please enter in a email address")
    @Email(message = "Please enter in the correct email format")
    private String email;
    private String type;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "EmailAddressID", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return this.emailAddressId;
    }

    public void setID(Integer entityKey) {
        this.emailAddressId = entityKey;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 320)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        EmailAddress that = (EmailAddress) o;

        if (emailAddressId != that.emailAddressId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emailAddressId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
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
