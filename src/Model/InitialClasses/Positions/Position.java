package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

public class Position {
    private final int id;
    private final Futures futures;
    private final String account;

    public Position(int id, String account, Futures futures) {
        this.id = id;
        this.account = account;
        this.futures = futures;
    }

    public double getBuyPower() {
        return NinjaTraderTerminal.INSTANCE.BuyingPower(account);
    }

    public double getCashValue() {
        return NinjaTraderTerminal.INSTANCE.CashValue(account);
    }

    public int getCurrentContractsAmount() {
        return NinjaTraderTerminal.INSTANCE.MarketPosition(futures.getTicker(), account);
    }

    public double getProfitLoss() {
        return NinjaTraderTerminal.INSTANCE.RealizedPnL(account);
    }

    public Futures getFutures() {
        return futures;
    }
}
