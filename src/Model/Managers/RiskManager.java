package Model.Managers;

import Model.BasicClasses.Futures;


//должен анализировать пару фьючей, придётся переделывать
public class RiskManager implements Manager {

    private MoneyManager moneyManager;
    private PositionManager positionManager;
    private double riskRate;
    private double marginRate;
    private double distanceToMarginLevel;
    private double marginLevel;

    //subsidiary
    private double numerator;
    private double denominator;
    private Futures futures;

    //deviation added to riskRate in Builder!
    public RiskManager(MoneyManager moneyManager, PositionManager positionManager, double riskRate, double deviation) {
        this.moneyManager = moneyManager;
        this.positionManager = positionManager;
        this.riskRate = riskRate + deviation;
    }

    public double getDistanceToMarginLevel() {
        return distanceToMarginLevel;
    }

    public double getMarginLevel() {
        return marginLevel;
    }

    public double getMarginRate() {
        return marginRate;
    }

    public double getRiskRate() {
        return riskRate;
    }

//    isRisk

    private void calculateSubsidiaryVariables() {
        numerator = moneyManager.getCurrentMoney() + moneyManager.getInMarketMoney();
        denominator = moneyManager.getInMarketMoney() * riskRate;
        futures = positionManager.getPositions().get(0).getFutures();
    }

    private void calculateMarginRate() {
        marginRate = numerator / denominator;
    }

    private void calculateDistanceToMarginLevel() {
        double difference = 1 - marginRate;

        double step = futures.getPriceStep();
        double valueStep = futures.getPriceStepValue();
        distanceToMarginLevel = numerator * difference / valueStep * step;
    }

    //take a bid
    private void calculateMarginLevel() {
//        marginLevel =
    }

    @Override
    public void updateInformation() {
        calculateSubsidiaryVariables();
        calculateMarginRate();
        calculateDistanceToMarginLevel();
        calculateMarginLevel();
    }
}
