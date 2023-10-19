package grapher.interactor.shapes;

public class PointsOnSide {
    private final int countPoints;
    private final double distance;

    public PointsOnSide(int countPoints, double distance) {
        this.countPoints = countPoints;
        this.distance = distance;
    }

    public int getCountPoints() {
        return countPoints;
    }

    public double getDistance() {
        return distance;
    }
}
