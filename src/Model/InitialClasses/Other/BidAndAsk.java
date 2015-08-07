package Model.InitialClasses.Other;


public class BidAndAsk {

    private final String ticker;

    public BidAndAsk(String ticker) {
        this.ticker = ticker;
    }

    public double getAsk() {
        return NinjaTraderTerminal.INSTANCE.MarketData(ticker, 2);
    }

    public double getBid() {
        return NinjaTraderTerminal.INSTANCE.MarketData(ticker, 1);
    }

}
