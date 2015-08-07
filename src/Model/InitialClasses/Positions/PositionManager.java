package Model.InitialClasses.Positions;



public class PositionManager {

    private static PositionManager instance;

    public static PositionManager getInstance() {
        if (instance == null) {
            return new PositionManager();
        }
        return instance;
    }




}
