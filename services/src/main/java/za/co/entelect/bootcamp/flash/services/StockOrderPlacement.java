package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.*;
import za.co.entelect.bootcamp.flash.persistence.IssueRepository;
import za.co.entelect.bootcamp.flash.persistence.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.SupplierRepository;

import java.sql.Date;

/**
 * Created by kevin.gouws on 2017/01/17.
 */
public class StockOrderPlacement {

    private IssueRepository issueRepository;
    private OrderRepository orderRepository;
    private PaymentService paymentService;
    private SupplierQuote supplierQuote;
    private SupplierRepository supplierRepository;
    private SupplierService supplierService;
    private int orderID;

    public StockOrderPlacement(IssueRepository issueRepository, OrderRepository orderRepository,
                               PaymentService paymentService, SupplierQuote supplierQuote,
                               SupplierRepository supplierRepository, SupplierService supplierService) {
        this.issueRepository = issueRepository;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.supplierQuote = supplierQuote;
        this.supplierRepository = supplierRepository;
        this.supplierService = supplierService;
        this.orderID = 0;
    }

    public String placeOrder(int issueID, int quantity) throws Exception {
        IssueOrderDTOAdapterFactory issueOrderDTOAdapterFactory = new IssueOrderDTOAdapterFactory();
        Issue issue = issueRepository.getByID(issueID);
        Supplier supplier = supplierRepository.getByID(supplierQuote.getSupplierID());
        if (issue == null) {
            throw new Exception("Issue does not exist");
        } else if (supplier == null) {
            throw new Exception("Supplier does not exist");
        }
        orderID++;

        IssueOrderDTOAdapter issueOrderDTOAdapter =
                issueOrderDTOAdapterFactory.createIssueOrderDTOAdapter(issue, quantity);
        this.supplierService.placeOrder(issueOrderDTOAdapter, supplier.getReferenceNumber(), quantity);
        double orderTotal = supplierQuote.getPrice() * quantity;
        Order newOrder = new Order(orderID, new Date(20171230), issueID, (short) quantity, orderTotal,
                "Ref#1337", new Date(20171230), "Pending",
                supplierQuote.getSupplierID());
        orderRepository.create(newOrder);
        return "Success";
    }

    public void makePayment(int orderID) throws Exception {
        SupplierPaymentDTOAdapterFactory supplierPaymentDTOAdapterFactory = new SupplierPaymentDTOAdapterFactory();
        Supplier supplier = supplierRepository.getByID(supplierQuote.getSupplierID());
        if (supplier == null) {
            throw new Exception("Supplier does not exist");
        }
        SupplierPaymentDTOAdapter supplierPaymentDTOAdapter =
                supplierPaymentDTOAdapterFactory.createSupplierPaymentDTOAdapter(supplier,
                        new SupplierPayment(orderID+100, orderID,
                                orderRepository.getByID(orderID).getTotal(), new Date(20171230)));
        this.paymentService.makePayment(supplierPaymentDTOAdapter);
    }
}
