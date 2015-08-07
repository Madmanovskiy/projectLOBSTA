package Model.InitialClasses.Positions;


import Model.InitialClasses.Other.Futures;

public class Position {
    private final int id;
    private final Futures futures;
    private int currentContractsAmount;
    private double cashValue;
    private double buyPower;
    private double profitLoss;

    public Position(int id, Futures futures, int currentContractsAmount) {
        this.futures = futures;
        this.id = id;
        this.currentContractsAmount = currentContractsAmount;
    }




}
