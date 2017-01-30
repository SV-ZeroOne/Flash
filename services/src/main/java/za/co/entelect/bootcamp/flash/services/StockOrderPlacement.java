package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issue;
import za.co.entelect.bootcamp.flash.persistence.Implementation.IssueRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.SupplierQuoteRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.SupplierRepository;

/**
 * Created by kevin.gouws on 2017/01/17.
 */
public class StockOrderPlacement {

    private IssueRepository issueRepository;
    private OrderRepository orderRepository;
    private SupplierQuoteRepository supplierQuoteRepository;
    private SupplierRepository supplierRepository;
    private IssueOrderDTOAdapterFactory issueOrderDTOAdapterFactory;
    private SupplierPaymentDTOAdapterFactory supplierPaymentDTOAdapterFactory;

    public StockOrderPlacement(IssueRepository issueRepository, OrderRepository orderRepository,
                               SupplierRepository supplierRepository, SupplierQuoteRepository supplierQuoteRepository,
                               IssueOrderDTOAdapterFactory issueOrderDTOAdapterFactory,
                               SupplierPaymentDTOAdapterFactory supplierPaymentDTOAdapterFactory) {
        this.issueRepository = issueRepository;
        this.orderRepository = orderRepository;
        this.supplierQuoteRepository = supplierQuoteRepository;
        this.supplierRepository = supplierRepository;
        this.issueOrderDTOAdapterFactory = issueOrderDTOAdapterFactory;
        this.supplierPaymentDTOAdapterFactory = supplierPaymentDTOAdapterFactory;
    }

    public Issue getIssue(int issueID) {
        return issueRepository.read(issueID);
    }
}
