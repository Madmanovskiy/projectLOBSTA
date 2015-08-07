package Model.InitialClasses.Orders;


import java.util.HashMap;
import java.util.Map;


public class OrderManager {

    private static OrderManager instance;
    private Map<Integer, Order> allIdHere = new HashMap<>();

    public static OrderManager getInstance() {
        if (instance == null) {
            return new OrderManager();
        }
        return instance;

    }

    //if id = -13, than LOBSTA will send empty Id, when it try execute 'doOrder'
    //if id<0 and != - 13, LOBSTA will send auto generated Id;

    public void sendCancelOrder(int cancelId) {
        new Order.OrderBuilder(cancelId, Order.Command.CANCEL)
                .build()
                .doOrder();
    }

    public void sendCancelAllOrders() {
        new Order.OrderBuilder(-13, Order.Command.CANCELALLORDERS)
                .build()
                .doOrder();
    }

    public void sendBuyLimitOrder(String account, String instrument, double price, int quantity) {
        new Order.OrderBuilder(-100, Order.Command.PLACE)
                .account(account)
                .instrument(instrument)
                .action(Order.Action.BUY)
                .quantity(quantity)
                .orderType(Order.OrderType.LIMIT)
                .limitPrice(price)
                .timeInForce(Order.TIF.GTC)
                .build()
                .doOrder();
    }

    public void sendBuyMarketOrder(String account, String instrument,int quantity) {
        new Order.OrderBuilder(-100, Order.Command.PLACE)
                .account(account)
                .instrument(instrument)
                .action(Order.Action.BUY)
                .quantity(quantity)
                .orderType(Order.OrderType.MARKET)
                .timeInForce(Order.TIF.GTC)
                .build()
                .doOrder();
    }

    public void sendSellLimitOrder(String account, String instrument, double price, int quantity) {
        new Order.OrderBuilder(-100, Order.Command.PLACE)
                .account(account)
                .instrument(instrument)
                .action(Order.Action.SELL)
                .quantity(quantity)
                .orderType(Order.OrderType.LIMIT)
                .limitPrice(price)
                .timeInForce(Order.TIF.GTC)
                .build()
                .doOrder();
    }

    public void sendSellMarketOrder(String account, String instrument,int quantity) {
        new Order.OrderBuilder(-100, Order.Command.PLACE)
                .account(account)
                .instrument(instrument)
                .action(Order.Action.SELL)
                .quantity(quantity)
                .orderType(Order.OrderType.MARKET)
                .timeInForce(Order.TIF.GTC)
                .build()
                .doOrder();
    }

    public void sendReplaceOrder(int replaceOrderId, double price, int quantity) {
        new Order.OrderBuilder(replaceOrderId, Order.Command.CHANGE)
                .quantity(quantity)
                .limitPrice(price)
                .build()
                .doOrder();
    }

    protected void addOrderToMap(int id, Order order) {
        allIdHere.put(id, order);
    }

}
