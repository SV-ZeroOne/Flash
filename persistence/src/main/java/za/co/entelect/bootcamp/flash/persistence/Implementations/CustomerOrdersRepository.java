package za.co.entelect.bootcamp.flash.persistence.Implementations;

import za.co.entelect.bootcamp.flash.domain.CustomerOrders;
import za.co.entelect.bootcamp.flash.persistence.Interfaces.CustomerOrdersInterface;
import za.co.entelect.bootcamp.flash.persistence.RepositoryImplementation;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class CustomerOrdersRepository extends RepositoryImplementation<Integer, CustomerOrders>
        implements CustomerOrdersInterface {
}
