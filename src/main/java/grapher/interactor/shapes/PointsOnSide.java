package grapher.interactor.shapes;

public class PointsOnSide {
    private int countPointsOnSide;
    private double distanceOnSide;

    public PointsOnSide(int countPointsOnSide, double distanceOnSide) {
        this.countPointsOnSide = countPointsOnSide;
        this.distanceOnSide = distanceOnSide;
    }

    public int getCountPointsOnSide() {
        return countPointsOnSide;
    }

    public double getDistanceOnSide() {
        return distanceOnSide;
    }
}
