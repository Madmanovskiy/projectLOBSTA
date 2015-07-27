package Model.BasicClasses;


public class UserOrder {

    private Futures instrument;
    private double price;
    private int quantity;
    private TypeOrder type;
    private StateOrder state;
    private int departedContract;
    private int remainingQuantity;
    private double summ;

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

    public double orderSum() {
        return ((double) quantity) * price;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    public boolean isExecuted() {
        return quantity == (departedContract + remainingQuantity);
    }

    public void updateQuantityInformation(int departedContract) {
        this.departedContract = departedContract;
        remainingQuantity = quantity - departedContract;
    }
}
