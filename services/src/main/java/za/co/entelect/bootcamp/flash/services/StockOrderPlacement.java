package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Order;
import za.co.entelect.bootcamp.flash.persistence.Implementation.IssueRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.SupplierQuoteRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.SupplierRepository;

/**
 * Created by kevin.gouws on 2017/01/17.
 */
public class StockOrderPlacement {

    private PaymentService paymentService;
    private SupplierService supplierService;
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

    public Order getOrderByID(int id) {
        return orderRepository.read(id);
    }

    /*public String placeOrder(int issueID, int quantity) throws Exception {
        IssueOrderDTOAdapterFactory issueOrderDTOAdapterFactory = new IssueOrderDTOAdapterFactory();
        Issue issue = issueRepository.read(issueID);
        Supplier supplier = supplierRepository.read(supplierQuote.getSupplierID());
        if (issue == null) {
            throw new Exception("Issue does not exist");
        } else if (supplier == null) {
            throw new Exception("Supplier does not exist");
        }
        orderID++;

        IssueOrderDTOAdapter issueOrderDTOAdapter =
                issueOrderDTOAdapterFactory.createIssueOrderDTOAdapter(issue, quantity);
        this.supplierService.placeOrder(issueOrderDTOAdapter, supplier.getReferenceNumber(), quantity);
        BigDecimal orderTotal = supplierQuote.getPrice().multiply(new BigDecimal(quantity));
        Order newOrder = new Order(orderID, new Date(20171230), issueID, (short) quantity, orderTotal,
                "Ref#1337", new Date(20171230), "Pending",
                supplierQuote.getSupplierID());
        orderRepository.create(newOrder);
        return "Success";
    }

    public void makePayment(int orderID) throws Exception {
        SupplierPaymentDTOAdapterFactory supplierPaymentDTOAdapterFactory = new SupplierPaymentDTOAdapterFactory();
        Supplier supplier = supplierRepository.read(supplierQuote.getSupplierID());
        if (supplier == null) {
            throw new Exception("Supplier does not exist");
        }
        SupplierPaymentDTOAdapter supplierPaymentDTOAdapter =
                supplierPaymentDTOAdapterFactory.createSupplierPaymentDTOAdapter(supplier,
                        new SupplierPayment(orderID+100, orderID,
                                orderRepository.read(orderID).getTotal(), new Date(20171230)));
        this.paymentService.makePayment(supplierPaymentDTOAdapter);
    }*/
}
