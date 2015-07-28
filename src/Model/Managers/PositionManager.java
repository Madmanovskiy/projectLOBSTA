package Model.Managers;

import Model.BasicClasses.Position;
import Model.BasicClasses.StatePosition;

import java.util.ArrayList;
import java.util.List;

public class PositionManager implements Manager {

    private List<Position> positions = new ArrayList<>();
    private List<Position> tempList = new ArrayList<>();
    private double profit;
    private double commissionSum;

    public double getCommissionSum() {
        return commissionSum;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public double getProfit() {
        return profit;
    }

    public boolean addPosition(Position p) {
        return positions.add(p);
    }

    private void calculateProfitSum() {
        if (positions.isEmpty()) {
            return;
        }
        for (Position p : positions){
            profit += p.calculateCurrentResult();
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
            if (p.getStatePosition() == StatePosition.IN_CASH) tempList.add(p);
        }
        positions.removeAll(tempList);
        tempList.clear();

    }

    @Override
    public void updateInformation() {
        calculateCommissionSum();
        calculateProfitSum();
        removeClosedPositions();
    }
}
