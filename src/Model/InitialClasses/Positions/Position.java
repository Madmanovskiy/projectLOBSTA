package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

public class Position {
    private final int id;
    private final Futures futures;
    private final String account;

    protected Position(int id, String account, Futures futures) {
        this.id = id;
        this.account = account;
        this.futures = futures;
    }

    protected double getBuyPower() {
        return NinjaTraderTerminal.INSTANCE.BuyingPower(account);
    }

    protected double getCashValue() {
        return NinjaTraderTerminal.INSTANCE.CashValue(account);
    }

    protected int getCurrentContractsAmount() {
        return NinjaTraderTerminal.INSTANCE.MarketPosition(futures.getTicker(), account);
    }

    protected double getProfitLoss() {
        return NinjaTraderTerminal.INSTANCE.RealizedPnL(account);
    }

    protected Futures getFutures() {
        return futures;
    }
}
