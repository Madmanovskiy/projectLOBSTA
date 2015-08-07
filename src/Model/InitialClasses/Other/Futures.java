package Model.InitialClasses.Other;


import java.util.Date;

public class Futures {

    private final String futuresName;
    private final String ticker;
    private final double guaranteeSum;
    private final double guaranteeSumLower;
    private final Date expirationDate;
    private final double priceStep;
    private final double priceStepValue;
    private final double stockExCommission;
    private final double brokerageCommission;

    private BidAndAsk middlePrices;

    public Futures(String futuresName, String ticker, double guaranteeSum,
                   double guaranteeSumLower, Date expirationDate, double priceStep,
                   double priceStepValue, double brokerageCommission, double stockExCommission,
                   BidAndAsk middlePrices) {
        this.futuresName = futuresName;
        this.ticker = ticker;
        this.guaranteeSum = guaranteeSum;
        this.guaranteeSumLower = guaranteeSumLower;
        this.expirationDate = expirationDate;
        this.priceStep = priceStep;
        this.priceStepValue = priceStepValue;
        this.brokerageCommission = brokerageCommission;
        this.stockExCommission = stockExCommission;
        this.middlePrices = middlePrices;
    }

    public double getBrokerageCommission() {
        return brokerageCommission;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getFuturesName() {
        return futuresName;
    }

    public double getGuaranteeSum() {
        return guaranteeSum;
    }

    public double getGuaranteeSumLower() {
        return guaranteeSumLower;
    }

    public double getPriceStep() {
        return priceStep;
    }

    public double getPriceStepValue() {
        return priceStepValue;
    }

    public double getStockExCommission() {
        return stockExCommission;
    }

    public double getAllCommissionCosts(){
        return stockExCommission + brokerageCommission;
    }

    public String getTicker() {
        return ticker;
    }

    public double getBidPrice(){
        return middlePrices.getBid();
    }

    public double getOfferPrice(){
        return middlePrices.getAsk();
    }

}
