package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.UserRolesRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class UserRoleService {

    private UserRolesRepository userRolesRepository;

    public UserRoleService(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }
}