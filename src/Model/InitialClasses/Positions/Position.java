package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

public class Position {
    private final Futures futures;
    private final String account;
    private final double priceEnter;

    protected Position(String account, Futures futures, double priceEnter) {
        this.account = account;
        this.futures = futures;
        this.priceEnter = priceEnter;
    }

    protected int getCurrentContractsQuantity() {
        return NinjaTraderTerminal.INSTANCE.MarketPosition(futures.getTicker(), account);
    }

    protected Futures getFutures() {
        return futures;
    }

    protected double currentPositionsResult(double currentPrice) {
        if (getCurrentContractsQuantity() == 0) return 0;
        return getCurrentContractsQuantity() > 0 ? currentPrice - priceEnter : priceEnter - currentPrice;
    }

    protected double commissionCosts(){
        return futures.getAllCommissionCosts() * getCurrentContractsQuantity();
    }
}
