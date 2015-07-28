package Model.BasicClasses;


public class UserOrder {

    private Futures instrument;
    private final double price;
    private final int quantity;
    private TypeOrder type;
    private StateOrder state;
    private int departedQuantity;
    private int remainingQuantity;

    public UserOrder(Futures instrument, double price, int quantity, TypeOrder type) {
        this.instrument = instrument;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        state = StateOrder.ACTIVE;
        departedQuantity = 0;
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

    public void setState(StateOrder state) {
        this.state = state;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setDepartedQuantity(int departedQuantity) {
        this.departedQuantity = departedQuantity;
    }

    public void calculateRemainingConatract(){
        remainingQuantity = quantity - departedQuantity;
    }

    public double orderVolume() {
        return ((double) quantity) * price;
    }

    public boolean isExecuted() {
        return quantity == (departedQuantity + remainingQuantity);
    }
}
