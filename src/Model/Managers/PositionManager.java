package Model.Managers;

import Model.BasicClasses.Position;
import Model.BasicClasses.StatePosition;

import java.util.ArrayList;
import java.util.List;

public class PositionManager implements Manager {

    private List<Position> positions = new ArrayList<>();
    private List<Position> tempPositionsList = new ArrayList<>();
    private double profitLoss;
    private double commissionSum;

    public double getCommissionSum() {
        return commissionSum;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public boolean addPosition(Position p) {
        return positions.add(p);
    }

    private void calculateProfitSum() {
        if (positions.isEmpty()) {
            return;
        }
        for (Position p : positions){
            profitLoss += p.calculateCurrentResult();
        }
    }

    private void calculateCommissionSum() {
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
        calculateProfitSum();
        removeClosedPositions();
    }
}
