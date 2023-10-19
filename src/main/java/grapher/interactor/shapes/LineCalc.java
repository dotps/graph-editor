package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class LineCalc {

    public static double getPerimeter(List<PointData> pointDataList) {

        PointData startPointData = null;
        double perimeter = 0;

        for (PointData pointData : pointDataList) {
            if (startPointData == null) {
                startPointData = pointData;
                continue;
            }
            perimeter = Math.floor(Math.sqrt(Math.pow(pointData.getX() - startPointData.getX(), 2) + Math.pow(pointData.getY() - startPointData.getY(), 2)));
        }

        return perimeter;
    }

    public static List<PointData> getPointsDataOnSurface(int countPoint, List<PointData> pointsData) {

        List<PointData> points = new ArrayList<>();

        int indexStartPoint = 0;
        int indexFinishPoint = 1;

        double x1 = pointsData.get(indexStartPoint).getX();
        double y1 = pointsData.get(indexStartPoint).getY();
        double x2 = pointsData.get(indexFinishPoint).getX();
        double y2 = pointsData.get(indexFinishPoint).getY();

        double xx = x1;
        double yy = y1;

        PointsOnSide2D pointsOnLine = getCountPointsOnSide(x1, y1, x2, y2, countPoint);

        int countPointsOnLine = pointsOnLine.getCountPoints();
        double distanceX = pointsOnLine.getDistanceX();
        double distanceY = pointsOnLine.getDistanceY();

        double directionX = Math.signum(x2 - x1);
        double directionY = Math.signum(y2 - y1);

        for (int indexPointOnLine = 0; indexPointOnLine < countPointsOnLine; indexPointOnLine++) {
            xx += distanceX * directionX;
            yy += distanceY * directionY;
            points.add(new PointData(xx, yy));
        }

        return points;
    }

    private static PointsOnSide2D getCountPointsOnSide(double x1, double y1, double x2, double y2, int countPoint) {

        double lengthX = Math.abs(x2 - x1);
        double lengthY = Math.abs(y2 - y1);

        double distanceX = lengthX / countPoint;
        double distanceY = lengthY / countPoint;

        return new PointsOnSide2D(countPoint, distanceX, distanceY);
    }
}

