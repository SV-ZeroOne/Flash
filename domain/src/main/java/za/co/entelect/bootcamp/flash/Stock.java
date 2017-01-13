package za.co.entelect.bootcamp.flash;

/**
 * Created by byron.dinkelmann on 2017/01/13.
 */
public class Stock {

    private int stockReferenceID;
    private int issueID;
    private String condition;
    private short availableQty;
    private float price;

    public Stock(){}

    public Stock(int stockReferenceID,int issueID,String condition,short availableQty, float price)
    {
        this.stockReferenceID=stockReferenceID;
        this.issueID=issueID;
        this.condition=condition;
        this.availableQty=availableQty;
        this.price=price;
    }

    public int getStockReferenceID() {
        return stockReferenceID;
    }

    public void setStockReferenceID(int stockReferenceID) {
        this.stockReferenceID = stockReferenceID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public short getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(short availableQty) {
        this.availableQty = availableQty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
