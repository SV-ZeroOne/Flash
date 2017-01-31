package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.EmailAddressRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class EmailAddressService {

    private EmailAddressRepository emailAddressRepository;

    public EmailAddressService(EmailAddressRepository emailAddressRepository) {
        this.emailAddressRepository = emailAddressRepository;
    }
}
