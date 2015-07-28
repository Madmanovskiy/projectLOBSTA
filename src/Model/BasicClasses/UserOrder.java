package Model.BasicClasses;


public class UserOrder {

    private Futures futures;
    private final double price;
    private final int quantity;
    private TypeOrder type;
    private StateOrder state;
    private int departedQuantity;
    private int remainingQuantity;

    public UserOrder(Futures futures, double price, int quantity, TypeOrder type) {
        this.futures = futures;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        state = StateOrder.ACTIVE;
        departedQuantity = 0;
        remainingQuantity = 0;
    }

    public Futures getFutures() {
        return futures;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public TypeOrder getType() {
        return type;
    }

    public StateOrder getState() {
        return state;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setDepartedQuantity(int departedQuantity) {
        this.departedQuantity = departedQuantity;
    }

    public void CalculateRemainingConatract(){
        remainingQuantity = quantity - departedQuantity;
    }

    public double getValueOfOrder(){
        return ((double) quantity) * futures.getGuaranteeAmountLower();
    }

    public boolean isExecuted() {
        return quantity == (departedQuantity + remainingQuantity);
    }
}
