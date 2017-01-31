package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementation.VouchersRepository;

/**
 * @author kevin.gouws - Created on 2017/01/31.
 */
public class VoucherService {

    private VouchersRepository vouchersRepository;

    public VoucherService(VouchersRepository vouchersRepository) {
        this.vouchersRepository = vouchersRepository;
    }
}
