package Model.BasicClasses;


public class Futures {

    private final String name;
    private final String ticker;
    private final double priceStep;
    private final double priceValueStep;
    private final double stockExchangeCommission;
    private final double brokersCommission;
    private double guaranteeAmountLower;
    private double guaranteeAmountGreater;
    private StockExchangeGlass glass;

    public Futures(String name, String ticker, double priceStep, double priceValueStep, double guaranteeAmountLower, double guaranteeAmountGreater, double stockExchangeCommission, double brokersCommission, StockExchangeGlass glass) {
        this.name = name;
        this.ticker = ticker;
        this.priceStep = priceStep;
        this.priceValueStep = priceValueStep;
        this.guaranteeAmountLower = guaranteeAmountLower;
        this.guaranteeAmountGreater = guaranteeAmountGreater;
        this.stockExchangeCommission = stockExchangeCommission;
        this.brokersCommission = brokersCommission;
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

    public double getStockExchangeCommission() {
        return stockExchangeCommission;
    }

    public double getBrokersCommission() {
        return brokersCommission;
    }

    public double calculateSumCommission(){
        return brokersCommission + stockExchangeCommission;
    }

    public StockExchangeGlass getGlass() {
        return glass;
    }
}
