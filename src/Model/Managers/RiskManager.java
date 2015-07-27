package Model.Managers;


public class RiskManager implements Manager {

    private static RiskManager instance;
    private double riskRate;
    private double potentionalDeviaton;
    private double marginRate;
    private double marginLvl;
    private double distanceToMarginLvl;
    private PortfolioManager portfolio;

    private RiskManager() {
        this.portfolio = PortfolioManager.getInstance();
    }

    public double getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(double riskRate) {
        this.riskRate = riskRate;
    }

    public double getPotentionalDeviaton() {
        return potentionalDeviaton;
    }

    public void setPotentionalDeviaton(double potentionalDeviaton) {
        this.potentionalDeviaton = potentionalDeviaton;
    }

    public double getMarginRate() {
        return marginRate;
    }

    public double getDistanceToMarginLvl() {
        return distanceToMarginLvl;
    }

    public boolean isCurrentRiskRateAcceptable(){
        return riskRate < marginRate;
    }




    public static synchronized RiskManager getInstance() {
        if (instance == null) {
            instance = new RiskManager();
        }
        return instance;
    }

    @Override
    public void updateInformation() {
        double tempNumerator = (portfolio.getWithoutResultMoney() + portfolio.getInMarketMoney());
        double tempDenominator = portfolio.getInMarketMoney() + portfolio.getInMarketMoney()*potentionalDeviaton;

        marginRate = tempNumerator/tempDenominator;
        marginLvl = tempNumerator*(1d - marginRate);


    }
}
