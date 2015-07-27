package Model.Managers;


import Model.BasicClasses.Position;

import java.util.ArrayList;
import java.util.List;

public class SingletonPortfolioManager implements Manager {

    private static SingletonPortfolioManager instance;
    private double money;
    private double availableMoney;
    private double blockedMoney;
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

    public double getAvailableMoney() {
        availableMoney = money - getBlockedMoney();
        return availableMoney;
    }

    public double getBlockedMoney() {
        if (positions.isEmpty()) return 0;

        for (Position pos : positions){
            blockedMoney += pos.getPositionSum();
        }

        return blockedMoney;
    }


    public List<Position> getPositions() {
        return positions;
    }

    public double getAssumeResult() {
        if (positions.isEmpty()) return 0;

        for (Position pos : positions){
            assumeResult+=pos.calculateCurrentResult();
        }
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

    }

}
