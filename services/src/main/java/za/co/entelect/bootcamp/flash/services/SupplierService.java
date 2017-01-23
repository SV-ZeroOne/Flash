package za.co.entelect.bootcamp.flash.services;

public interface SupplierService {
    public String placeOrder(IssueOrderDTO issueOrder, String supplierRefNumber, int quantity);
}

