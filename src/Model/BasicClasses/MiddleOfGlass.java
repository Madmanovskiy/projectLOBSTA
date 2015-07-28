package Model.BasicClasses;


public class MiddleOfGlass {
    private final String ticker;
    private double bestPrice;
    private double bestQuantity;

    public MiddleOfGlass(String name) {
        this.ticker = name;
    }

    public String getTicker() {
        return ticker;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public double getBestQuantity() {
        return bestQuantity;
    }

    public void setBestPrice(double bestPrice) {
        this.bestPrice = bestPrice;
    }

    public void setBestQuantity(double bestQuantity) {
        this.bestQuantity = bestQuantity;
    }

}

