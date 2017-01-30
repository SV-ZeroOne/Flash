package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.CreatorRepository;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class CreatorService {

    private CreatorRepository creatorRepository;

    public CreatorService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }
}
