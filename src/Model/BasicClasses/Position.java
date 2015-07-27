package Model.BasicClasses;


public class Position {
    private static int idPosition;
    private Futures futures;
    private int countOfContracts;
    double priceEnter;
    double priceExit;

    public Position(Futures futures, int idPosition, double priceEnter) {
        idPosition++;
        this.futures = futures;
        this.idPosition = idPosition;
        this.priceEnter = priceEnter;
    }

    public int getCountOfContracts() {
        return countOfContracts;
    }

    public Futures getFutures() {
        return futures;
    }

    public static int getIdPosition() {
        return idPosition;
    }

    public double getPriceEnter() {
        return priceEnter;
    }

    public double getPriceExit() {
        return priceExit;
    }

    public void setCountOfContracts(int countOfContracts) {
        this.countOfContracts = countOfContracts;
    }

    public void setPriceExit(double priceExit) {
        this.priceExit = priceExit;
    }

    public double getPositionSum() {
        return ((double) countOfContracts) * futures.getGuaranteeAmountLower();
    }

    public double calculateCurrentResult() {
        double currentPrice = countOfContracts > 0 ? futures.getGlass().getBestBidPrice() : futures.getGlass().getBestOfferPrice();
        return countOfContracts > 0 ? currentPrice - priceEnter : priceEnter - currentPrice;
    }

    public double calculateFinalResult() {
        return countOfContracts > 0 ? priceExit - priceEnter : priceEnter - priceExit;
    }
}