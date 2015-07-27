package Model.BasicClasses;


public class Futures {

    private final double priceStep;
    private final double priceValueStep;
    private final int stockExchangesCommision;
    private String name;
    private String ticker;
    private double guaranteeAmountLower;
    private double guaranteeAmountGreater;
    private StockExchangeGlass glass;

    public Futures(String name, String ticker, double priceStep, double priceValueStep, int guaranteeAmountLower, int guaranteeAmountGreater, int stockExchangesCommision, StockExchangeGlass glass) {
        this.name = name;
        this.ticker = ticker;
        this.priceStep = priceStep;
        this.priceValueStep = priceValueStep;
        this.guaranteeAmountLower = guaranteeAmountLower;
        this.guaranteeAmountGreater = guaranteeAmountGreater;
        this.stockExchangesCommision = stockExchangesCommision;
        this.glass = glass;
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

    public double getGuaranteeAmountLower() {
        return guaranteeAmountLower;
    }

    public double getGuaranteeAmountGreater() {
        return guaranteeAmountGreater;
    }

    public int getStockExchangesCommision() {
        return stockExchangesCommision;
    }

    public StockExchangeGlass getGlass() {
        return glass;
    }
}
