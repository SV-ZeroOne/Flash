package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.*;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
@Entity
public class UserRoles implements EntityInterface<Integer> {
    private int userRoleId;
    private String role;
    private CustomerAccounts customerAccountsByCustomerId;

    @Id
    @Column(name = "UserRoleID", nullable = false)
    public Integer getID() {
        return this.userRoleId;
    }

    public void setID(Integer entityKey) {
        this.userRoleId = entityKey;
    }

    @Basic
    @Column(name = "Role", nullable = false, length = 50)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (userRoleId != userRoles.userRoleId) return false;
        if (role != null ? !role.equals(userRoles.role) : userRoles.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
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
