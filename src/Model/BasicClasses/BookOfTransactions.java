package Model.BasicClasses;


import java.util.ArrayList;
import java.util.List;

public class BookOfTransactions {

    private static BookOfTransactions instance;
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

    public void updateListsData() {
        for (UserOrder order : orders){
            if (order.isExecuted()) {
                deals.add(order);
            }
        }
    }

    public static synchronized BookOfTransactions getInstance() {
        if (instance == null) instance = new BookOfTransactions();
        return instance;
    }

}
