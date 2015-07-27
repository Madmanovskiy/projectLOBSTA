package Model.BasicClasses;


public class UserOrder {

    private Futures instrument;
    private double price;
    private int quantity;
    private TypeOrder type;
    private StateOrder state;
    private int departedContract;
    private int remainingQuantity;

    public UserOrder(Futures instrument, double price, int quantity, TypeOrder type) {
        this.instrument = instrument;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        state = StateOrder.ACTIVE;
        departedContract = 0;
        remainingQuantity = 0;
    }

    public Futures getInstrument() {
        return instrument;
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

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    public boolean isExecuted() {
        return quantity == (departedContract + remainingQuantity) ? true : false;
    }

    public void updateQuantityInformation(int departedContract) {
        this.departedContract = departedContract;
        remainingQuantity = quantity - departedContract;
    }

    public enum TypeOrder {
        BUY_LIMIT,
        SELL_LIMIT,
        BUY_MARKET,
        SELL_MARKET
    }

    public enum StateOrder {
        ACTIVE,
        CANCELED,
        EXECUTED_IN_PART,
        EXECUTED
    }
}
