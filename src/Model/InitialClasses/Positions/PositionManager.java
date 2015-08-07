package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

import java.util.HashMap;
import java.util.Map;

public class PositionManager {

    private static PositionManager instance;
    private static Map<String, Position> positionMap = new HashMap();
    private final String account;

    private PositionManager(String account) {
        this.account = account;
    }

    public static PositionManager getInstance(String account) {
        if (instance == null) {
            return new PositionManager(account);
        }
        return instance;
    }


    public boolean isPositionWillBeCreate(Futures futures) {
        return NinjaTraderTerminal.INSTANCE.MarketPosition(account, futures.getTicker()) != 0;
    }

    public void createPosition(String account, Futures futures, double priceEnter) {
        positionMap.put(futures.getTicker(), new Position(account, futures, priceEnter));
    }

    public boolean isPositionClosed(Futures futures) {
        return positionMap.get(futures.getTicker()).getCurrentContractsQuantity() == 0;
    }

    public void removePosition(Futures futures) {
        positionMap.remove(futures.getTicker());
    }


    public double getBuyPower() {
        return NinjaTraderTerminal.INSTANCE.BuyingPower(account);
    }

    public double getCashValue() {
        return NinjaTraderTerminal.INSTANCE.CashValue(account);
    }


    public double getPositionResult(Futures futures, double currentPrice) {
        Position pos = positionMap.get(futures.getTicker());
        return pos.currentPositionsResult(currentPrice) - pos.getCurrentContractsQuantity() - pos.commissionCosts();
    }

    public double getSummaryCommissionCosts(){
        double commissions = 0;
        if (positionMap.isEmpty()) return 0;

        for (Map.Entry<String, Position> pair : positionMap.entrySet()){
            commissions+= pair.getValue().commissionCosts();
        }

        return commissions;
    }

    public double getSummaryProfitLoss() {
        return NinjaTraderTerminal.INSTANCE.RealizedPnL(account) - getSummaryCommissionCosts();
    }

    public int getPositionQuantity(Futures futures) {
        return positionMap.get(futures.getTicker()).getCurrentContractsQuantity();
    }


    public double getPositionValue(Futures futures) {
        return getPositionQuantity(futures) * futures.getGuaranteeSumLower();
    }

    public double getAllPositionsValue() {
        double posValue = 0;
        if (positionMap.isEmpty()) return 0;

        for (Map.Entry<String, Position> pair : positionMap.entrySet()){
            posValue += pair.getValue().getFutures().getGuaranteeSumLower();
        }

        return posValue;
    }

}
