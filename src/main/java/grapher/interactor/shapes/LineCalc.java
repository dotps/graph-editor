package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class LineCalc {

    public static int getPerimeter(List<PointData> pointDataList) {

        PointData startPointData = null;
        int perimeter = 0;

        for (PointData pointData : pointDataList) {
            if (startPointData == null) {
                startPointData = pointData;
                continue;
            }
            perimeter = (int) Math.floor(Math.sqrt(Math.pow(pointData.getX() - startPointData.getX(), 2) + Math.pow(pointData.getY() - startPointData.getY(), 2)));
        }

        return perimeter;
    }

    public static List<PointData> getPointsDataOnCurve(int countPoint, int perimeter, List<PointData> pointsData) {

        List<PointData> points = new ArrayList<>();

        // ЗАКОНЧИЛ

//        int excludeSidePoints = 4;
//        countPoint -= excludeSidePoints;

        countPoint += 2;


        double distance = perimeter / countPoint;
        debug.log("distance " + distance);

        for (int indexPoint = 0; indexPoint < pointsData.size(); indexPoint++) {

            double x1 = pointsData.get(indexPoint).getX();
            double y1 = pointsData.get(indexPoint).getY();
            double x2, y2;

            if (isPointInRange(pointsData.size(), indexPoint)) {
                x2 = pointsData.get(indexPoint + 1).getX();
                y2 = pointsData.get(indexPoint + 1).getY();
            }
            else {
                x2 = pointsData.get(0).getX();
                y2 = pointsData.get(0).getY();
            }

            double xx = x1;
            double yy = y1;

            PointsOnSide pointsOnSide = getCountPointsOnSide(x1, y1, x2, y2, perimeter, countPoint);
            int countPointsOnSide = pointsOnSide.getCountPointsOnSide();
            double distanceOnSide = pointsOnSide.getDistanceOnSide();

            double directionX = Math.signum(x2 - x1);
            double directionY = Math.signum(y2 - y1);

            for (int indexPointOnSide = 0; indexPointOnSide < countPointsOnSide; indexPointOnSide++) {
                xx += distanceOnSide * directionX;
                yy += distanceOnSide * directionY;
                PointData point = new PointData(xx, yy);
                points.add(point);
            }

        }
        return points;
    }

    private static PointsOnSide getCountPointsOnSide(double x1, double y1, double x2, double y2, int perimeter, int countPoint) {

        double lengthX = Math.abs(x2 - x1);
        double lengthY = Math.abs(y2 - y1);
        double xMultiply = perimeter / lengthX;
        double yMultiply = perimeter / lengthY;

        int countPointsX = (int) Math.floor(countPoint / xMultiply);
        int countPointsY = (int) Math.floor(countPoint / yMultiply);

        int countPointsOnSide = (countPointsX >= countPointsY) ? countPointsX : countPointsY;

        double distanceX = lengthX / countPointsOnSide;
        double distanceY = lengthY / countPointsOnSide;
        double distanceOnSide = (distanceX >= distanceY) ? distanceX : distanceY;

        debug.log("distanceX " + distanceX);
        debug.log("distanceY " + distanceY);

        return new PointsOnSide(countPointsOnSide, distanceOnSide);
    }

    private static boolean isPointInRange(int maxIndex, int currentIndex) {
        return currentIndex + 1 <= maxIndex - 1;
    }

}

