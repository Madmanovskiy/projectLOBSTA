package Model.BasicClasses;


public class StockExchangeGlass {

    private String ticker;
    private MiddleOfGlass bid;
    private MiddleOfGlass offer;

    public StockExchangeGlass(String ticker, MiddleOfGlass bid, MiddleOfGlass offer) {
        this.ticker = ticker;
        this.bid = bid;
        this.offer = offer;
    }

    public String getTicker() {
        return ticker;
    }

    public double getBestBidPrice(){
        return bid.getBestPrice();
    }

    public double getBestBidQuantity(){
        return bid.getBestQuantity();
    }

    public double getBestOfferPrice(){
        return offer.getBestPrice();
    }

    public double getBestOfferQuantity(){
        return offer.getBestQuantity();
    }
}
