package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

public class Position {
    private final Futures futures;
    private final String account;

    protected Position(String account, Futures futures) {
        this.account = account;
        this.futures = futures;
    }

    protected int getCurrentContractsAmount() {
        return NinjaTraderTerminal.INSTANCE.MarketPosition(futures.getTicker(), account);
    }

    protected Futures getFutures() {
        return futures;
    }
}
