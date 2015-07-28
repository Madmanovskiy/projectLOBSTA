package Model.Managers;

import Model.BasicClasses.BookOfTransactions;
import Model.BasicClasses.StateOrder;
import Model.BasicClasses.TypeOrder;
import Model.BasicClasses.UserOrder;

import java.util.ArrayList;
import java.util.List;


public class OrderManager implements Manager {

    private BookOfTransactions transactions;
    private List<UserOrder> tempList = new ArrayList<>();

    public OrderManager(BookOfTransactions transactions) {
        this.transactions = transactions;
    }

    public BookOfTransactions getTransactions() {
        return transactions;
    }

    public List<UserOrder> getOrderByType(TypeOrder typeOrder) {
        tempList.clear();
        for (UserOrder order : transactions.getOrders()){
            if (order.getType() == typeOrder) tempList.add(order);
        }

        return tempList;
    }

    public List<UserOrder> getOrderByState(StateOrder stateOrder) {
        tempList.clear();
        for (UserOrder order : transactions.getOrders()){
            if (order.getState() == stateOrder) tempList.add(order);
        }

        return tempList;
    }

    private void removeCancelledOrders() {
        tempList.clear();
        for (UserOrder order : transactions.getOrders()){
            if (order.getState() == StateOrder.CANCELED) tempList.add(order);
        }
        transactions.getOrders().removeAll(tempList);
    }

    private void addChangesToExecutedInPartOrders(){

    }


    private void transformExecutedOrderToDeal() {
        for (UserOrder order : transactions.getOrders()){
            if (order.isExecuted()) transactions.addDeal(order);
        }
    }


    @Override
    public void updateInformation() {
        removeCancelledOrders();
        addChangesToExecutedInPartOrders();
        transformExecutedOrderToDeal();
    }
}
