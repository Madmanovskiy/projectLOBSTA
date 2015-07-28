package Model.BasicClasses;


import java.util.ArrayList;
import java.util.List;

public class BookOfTransactions {

    private List<UserOrder> orders = new ArrayList<>();
    private List<UserOrder> deals = new ArrayList<>();

    public List<UserOrder> getOrders() {
        return orders;
    }

    public List<UserOrder> getDeals() {
        return deals;
    }

    public void addOrder(UserOrder order) {
        orders.add(order);
    }

    public void addDeal(UserOrder order) {
        deals.add(order);
    }

    public void removeOrder(UserOrder order) {
        orders.remove(order);
    }



    //IO to\from file, hasn't realization yet
    public void writeOrdersToFile(){

    }

    public void readOrdersFromFile(){

    }

    public void writeDealsToFile(){

    }

    public void readDealsFromFile(){

    }
}
