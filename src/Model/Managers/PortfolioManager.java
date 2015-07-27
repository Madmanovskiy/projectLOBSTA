package Model.Managers;


import Model.BasicClasses.BookOfTransactions;
import Model.BasicClasses.Position;
import Model.BasicClasses.UserOrder;

import java.util.ArrayList;
import java.util.List;

public class PortfolioManager implements Manager {

    private static PortfolioManager instance;
    private double startMoney;
    private double withoutResultMoney;
    private double blockedMoney;
    private double availableMoney;
    private double inMarketMoney;
    private double assumeResult;
    private List<Position> positions = new ArrayList<>();
    private BookOfTransactions transactions = BookOfTransactions.getInstance();

    private PortfolioManager() {
        withoutResultMoney = startMoney;
    }

    public double getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(double startMoney) {
        this.startMoney = startMoney;
    }

    public double getWithoutResultMoney() {
        return withoutResultMoney;
    }

    public double getBlockedMoney() {
        if (positions.isEmpty()) return 0;
        return blockedMoney;
    }

    public double getAvailableMoney() {

        return availableMoney;
    }

    public double getInMarketMoney() {
        return inMarketMoney;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public double getAssumeResult() {
        if (positions.isEmpty()) return 0;
        return assumeResult;
    }

    public static synchronized PortfolioManager getInstance() {
        if (instance == null) {
            instance = new PortfolioManager();
        }
        return instance;
    }

    @Override
    public void updateInformation() {
        //update blockedMoney & assumeResult
        for (Position pos : positions){
            inMarketMoney += pos.calculatePositionSum();
            assumeResult += pos.calculateCurrentResult();
        }

        for (UserOrder order : transactions.getOrders()){
            blockedMoney += order.orderSum();
        }
        //update withoutResultMoney
        withoutResultMoney = startMoney - assumeResult;

        //update availableMoney
        availableMoney = startMoney - inMarketMoney - blockedMoney - assumeResult;

    }

}
