package grapher.interactor.shapes;

public class PointsOnSide2D {
    private final int countPoints;
    private final double distanceX;
    private final double distanceY;

    public PointsOnSide2D(int countPoints, double distanceX, double distanceY) {
        this.countPoints = countPoints;
        this.distanceX = distanceX;
        this.distanceY = distanceY;
    }

    public int getCountPoints() {
        return countPoints;
    }

    public double getDistanceX() {
        return distanceX;
    }

    public double getDistanceY() {
        return distanceY;
    }
}
