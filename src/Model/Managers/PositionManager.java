package Model.Managers;

import Model.BasicClasses.Position;
import Model.BasicClasses.StatePosition;

import java.util.ArrayList;
import java.util.List;

public class PositionManager implements Manager {

    private List<Position> positions = new ArrayList<>();
    private List<Position> tempPositionsList = new ArrayList<>();
    private double currentProfitLoss;
    private double realizedProfitLoss;
    private double commissionSum;

    public double getCommissionSum() {
        return commissionSum;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public double getCurrentProfitLoss() {
        return currentProfitLoss;
    }

    public double getRealizedProfitLoss() {
        return realizedProfitLoss;
    }

    public boolean addPosition(Position p) {
        return positions.add(p);
    }

    private void calculateCurrentProfitSum() {
        if (positions.isEmpty()) {
            return;
        }
        currentProfitLoss = 0;
        for (Position p : positions){
            if (p.getStatePosition() != StatePosition.IN_CASH) currentProfitLoss += p.getCurrentResult();
        }
    }

    private void calculateRealizedProfitSum() {
        if (positions.isEmpty()) {
            return;
        }
        realizedProfitLoss = 0;
        for (Position p : positions){
            if (p.getStatePosition() == StatePosition.IN_CASH) currentProfitLoss += p.getRealizedResult();
        }
    }

    private void calculateCommissionSum() {
        commissionSum = 0;
        if (positions.isEmpty()) {
            return;
        }
        for (Position p : positions){
            commissionSum += p.getFutures().getCommissionSum();
        }
    }


    private void removeClosedPositions() {
        if (positions.isEmpty()) {
            return;
        }
        for (Position p : positions){
            if (p.getStatePosition() == StatePosition.IN_CASH) tempPositionsList.add(p);
        }
        positions.removeAll(tempPositionsList);
        tempPositionsList.clear();

    }

    @Override
    public void updateInformation() {
        calculateCommissionSum();
        calculateCurrentProfitSum();
        calculateRealizedProfitSum();
        removeClosedPositions();
    }
}
