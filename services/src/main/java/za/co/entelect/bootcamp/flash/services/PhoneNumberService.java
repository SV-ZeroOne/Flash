package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.PhoneNumbersRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class PhoneNumberService {

    private PhoneNumbersRepository phoneNumbersRepository;

    public PhoneNumberService(PhoneNumbersRepository phoneNumbersRepository) {
        this.phoneNumbersRepository = phoneNumbersRepository;
    }
}
