package za.co.entelect.bootcamp.flash.persistence.Implementation;

import za.co.entelect.bootcamp.flash.domain.UserRoles;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

import javax.persistence.Query;
import java.util.List;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class UserRolesRepository extends RepositoryImplementation<Integer, UserRoles>
        implements UserRolesInterface {

    public List<UserRoles> getUserRolesByCustomerId(int customerId){
        Query getRoles = entityManager
                .createQuery("SELECT ur FROM UserRoles ur WHERE ur.customerAccountsByCustomerId.id = :customerId")
                .setParameter("customerId", customerId);
        return  getRoles.getResultList();
    }
}
