package Model.InitialClasses.Orders;


import Model.InitialClasses.Other.NinjaTraderTerminal;

public class Order {

    private final int orderId;
    private final String command;
    private final String account;
    private final String instrument;
    private final String action;
    private final int quantity;
    private final String orderType;
    private final double limitPrice;
    private final double stopPrice;
    private final String timeInForce;
    private final String oco;
    private final String strategy;
    private final String strategyId;

    public Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.account = builder.account;
        this.command = builder.command;
        this.instrument = builder.instrument;
        this.action = builder.action;
        this.quantity = builder.quantity;
        this.orderType = builder.orderType;
        this.limitPrice = builder.limitPrice;
        this.stopPrice = builder.stopPrice;
        this.timeInForce = builder.timeInForce;
        this.oco = builder.oco;
        this.strategy = builder.strategy;
        this.strategyId = builder.strategyId;
        OrderManager.getInstance().addOrderToMap(orderId, this);
    }

    public static class OrderBuilder {
        private final int orderId;
        private final String command;
        private String account = "";
        private String action = "";
        private String instrument = "";
        private int quantity = 0;
        private String orderType = "";
        private double limitPrice = 0;
        private double stopPrice = 0;
        private String timeInForce = "";
        private String oco = "";
        private String strategy = "";
        private String strategyId = "";

        public OrderBuilder(int orderId, Command command) {
            if (orderId < 0) {
                this.orderId = Integer.valueOf(NinjaTraderTerminal.INSTANCE.NewOrderId());
            } else {
                this.orderId = orderId;
            }
            this.command = command.toString();
        }

        public OrderBuilder account(String val) {
            account = val;
            return this;
        }

        public OrderBuilder action(Action val) {
            action = val.toString();
            return this;
        }

        public OrderBuilder instrument(String val) {
            instrument = val;
            return this;
        }

        public OrderBuilder quantity(int val) {
            quantity = val;
            return this;
        }

        public OrderBuilder orderType(OrderType val) {
            orderType = val.toString();
            return this;
        }

        public OrderBuilder limitPrice(double val) {
            limitPrice = val;
            return this;
        }

        public OrderBuilder stopPrice(double val) {
            stopPrice = val;
            return this;
        }

        public OrderBuilder timeInForce(TIF val) {
            timeInForce = val.toString();
            return this;
        }

        public OrderBuilder oco(String val) {
            oco = val;
            return this;
        }

        public OrderBuilder strategy(String val) {
            strategy = val;
            return this;
        }

        public OrderBuilder strategyId(String val) {
            strategyId = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    protected boolean doOrder() {
        String orderIdTemp;
        if (orderId == -13) {
            orderIdTemp = "";
        } else {
            orderIdTemp = String.valueOf(orderId);
        }
        return NinjaTraderTerminal.INSTANCE.Command(command, account, instrument, action,
                        quantity, orderType, limitPrice, stopPrice, timeInForce, oco, orderIdTemp,
                        strategy, strategyId) == 0;
    }

    protected int remainingContracts(int orderId){
        String orderIdTemp = String.valueOf(orderId);
        return this.quantity - NinjaTraderTerminal.INSTANCE.Filled(orderIdTemp);
    }
    public enum Command {
        CANCEL,
        CANCELALLORDERS,
        CHANGE,
        CLOSEPOSITION,
        CLOSESTRATEGY,
        FLATTENEVERYTHING,
        PLACE,
        REVERSEPOSITION,
        NO_COMMAND
    }

    public enum Action {
        BUY,
        SELL,
        NO_ACTION
    }

    public enum OrderType {
        MARKET,
        LIMIT,
        //STOP,
        //STOPLIMIT,
        NO_TYPE
    }

    public enum TIF {
        DAY,
        GTC,
        NO_TIF
    }

}


