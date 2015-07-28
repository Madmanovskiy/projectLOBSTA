package Model.Managers;

/**
 * Created by Maksim on 28.07.2015.
 */
public class MoneyManager implements Manager {

    private final double startMoney;
    private double currentMoney;
    private double availableMoney;
    private double inMarketMoney;

    public MoneyManager(double startMoney) {
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



    @Override
    public void updateInformation() {

    }
}
