package Model.BasicClasses;


public class Futures {

    private final double priceStep;
    private final double priceValueStep;
    private final int stockExchangesCommision;
    private final int countOfDecimalPlacesInPrice;
    private String name;
    private String ticker;
    private int guaranteeAmountLower;
    private int guaranteeAmountGreater;

    public Futures(String name, String ticker, int countOfDecimalPlacesInPrice, double priceStep, double priceValueStep, int guaranteeAmountLower, int guaranteeAmountGreater, int stockExchangesCommision) {
        this.name = name;
        this.ticker = ticker;
        this.countOfDecimalPlacesInPrice = countOfDecimalPlacesInPrice;
        this.priceStep = priceStep;
        this.priceValueStep = priceValueStep;
        this.guaranteeAmountLower = guaranteeAmountLower;
        this.guaranteeAmountGreater = guaranteeAmountGreater;
        this.stockExchangesCommision = stockExchangesCommision;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPriceStep() {
        return priceStep;
    }

    public double getPriceValueStep() {
        return priceValueStep;
    }

    public int getGuaranteeAmountLower() {
        return guaranteeAmountLower;
    }

    public int getGuaranteeAmountGreater() {
        return guaranteeAmountGreater;
    }

    public int getStockExchangesCommision() {
        return stockExchangesCommision;
    }
}
