package Model.BasicClasses;


public class MiddleOfGlass {
    private double bestPrice;
    private double bestQuantity;

    public MiddleOfGlass(double bestPrice, double bestQuantity) {
        this.bestPrice = bestPrice;
        this.bestQuantity = bestQuantity;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public double getBestQuantity() {
        return bestQuantity;
    }
}

