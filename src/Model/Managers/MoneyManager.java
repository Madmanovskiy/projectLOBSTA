package Model.Managers;

import Model.BasicClasses.Position;
import Model.BasicClasses.UserOrder;

public class MoneyManager implements Manager {

    private PositionManager positionManager;
    private OrderManager orderManager;
    private final double startMoney;
    private double currentMoney;
    private double availableMoney;
    private double inMarketMoney;

    public MoneyManager(PositionManager positionManager, OrderManager orderManager, double startMoney) {
        this.positionManager = positionManager;
        this.orderManager = orderManager;
        this.startMoney = startMoney;
    }

    public double getStartMoney() {
        return startMoney;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public double getInMarketMoney() {
        return inMarketMoney;
    }

    // with positions value
    private void calculateCurrentMoney() {
        currentMoney = startMoney + positionManager.getCurrentProfitLoss() + positionManager.getRealizedProfitLoss() - positionManager.getCommissionSum();
    }

    private void calculateInMarketMoney() {
        inMarketMoney = 0;
        for (Position p : positionManager.getPositions()){
            inMarketMoney += p.getPositionSum();
        }

    }

    private void calculateAvailableMoney() {
        double blockerMoney = 0;
        for (UserOrder uo : orderManager.getTransactions().getOrders()){
            blockerMoney += uo.getValueOfOrder();
        }
        availableMoney = currentMoney - inMarketMoney - blockerMoney;
    }


    @Override
    public void updateInformation() {
        calculateCurrentMoney();
        calculateInMarketMoney();
        calculateAvailableMoney();
    }
}
