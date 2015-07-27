package Model.Managers;


import Model.BasicClasses.Position;

import java.util.ArrayList;
import java.util.List;

public class SingletonPortfolioManager implements Manager {

    private static SingletonPortfolioManager instance;
    private double money;
    private double blockedMoney;
    private double availableMoney;
    private double assumeResult;
    private List<Position> positions = new ArrayList<>();

    private SingletonPortfolioManager() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getBlockedMoney() {
        if (positions.isEmpty()) return 0;
        return blockedMoney;
    }

    public double getAvailableMoney() {

        return availableMoney;
    }


    public List<Position> getPositions() {
        return positions;
    }

    public double getAssumeResult() {
        if (positions.isEmpty()) return 0;
        return assumeResult;
    }

    public static synchronized SingletonPortfolioManager getInstance() {
        if (instance == null) {
            instance = new SingletonPortfolioManager();
        }
        return instance;
    }

    @Override
    public void updateInformation() {
        //update blockedMoney
        for (Position pos : positions){
            blockedMoney += pos.getPositionSum();
        }

        //update availableMoney
        availableMoney = money - blockedMoney;

        //update assumeResult
        for (Position pos : positions){
            assumeResult += pos.calculateCurrentResult();
        }
    }

}
