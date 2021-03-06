package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.persistence.Implementations.IssueRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementations.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementations.SupplierQuoteRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementations.SupplierRepository;

/**
 * @author kevin.gouws - Created on 2017/01/17.
 */
public class StockOrderPlacement {

    private IssueRepository issueRepository;
    private OrderRepository orderRepository;
    private SupplierQuoteRepository supplierQuoteRepository;
    private SupplierRepository supplierRepository;

    public StockOrderPlacement(IssueRepository issueRepository, OrderRepository orderRepository,
                               SupplierRepository supplierRepository, SupplierQuoteRepository supplierQuoteRepository) {
        this.issueRepository = issueRepository;
        this.orderRepository = orderRepository;
        this.supplierQuoteRepository = supplierQuoteRepository;
        this.supplierRepository = supplierRepository;
    }

    public Issues getIssue(int issueID) {
        return issueRepository.read(issueID);
    }
}
