package Model.BasicClasses;


public class StockExchangeGlass {

    private String ticker;
    private MiddleOfGlass bid;
    private MiddleOfGlass offer;

    public StockExchangeGlass(MiddleOfGlass bid, MiddleOfGlass offer) {
        this.bid = bid;
        this.offer = offer;
        ticker = bid.getTicker();
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

    public void setBid(MiddleOfGlass bid) {
        this.bid = bid;
    }

    public void setOffer(MiddleOfGlass offer) {
        this.offer = offer;
    }
}
