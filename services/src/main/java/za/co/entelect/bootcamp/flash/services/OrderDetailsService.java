package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.persistence.Implementations.OrderDetailsRepository;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
public class OrderDetailsService {

    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsRepository getOrderDetailsRepository() {
        return orderDetailsRepository;
    }

    public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {

        this.orderDetailsRepository = orderDetailsRepository;
    }
}
