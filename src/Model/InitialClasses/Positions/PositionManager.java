package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;
import Model.InitialClasses.Other.NinjaTraderTerminal;

import java.util.HashMap;
import java.util.Map;

public class PositionManager {

    private static PositionManager instance;
    private static Map<String, Position> positionMap = new HashMap();
    private final String account;
    private double commissionCosts;

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

    public void createPosition(String account, Futures futures) {
        positionMap.put(futures.getTicker(), new Position(account, futures));
        commissionCosts += positionMap.get(futures.getTicker()).getCurrentContractsAmount() * futures.getAllCommissionCosts();
    }

    public boolean isPositionClosed(Futures futures) {
        return positionMap.get(futures.getTicker()).getCurrentContractsAmount() == 0;
    }

    public void removePosition(Futures futures) {
        positionMap.remove(futures.getTicker());
    }

    public double getBuyPower() {
        return NinjaTraderTerminal.INSTANCE.BuyingPower(account) - commissionCosts;
    }

    public double getCashValue() {
        return NinjaTraderTerminal.INSTANCE.CashValue(account) - commissionCosts;
    }

    protected double getProfitLoss() {
        return NinjaTraderTerminal.INSTANCE.RealizedPnL(account) - commissionCosts;
    }

    public int getPositionQuantity(Futures futures) {
        return positionMap.get(futures.getTicker()).getCurrentContractsAmount();
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
