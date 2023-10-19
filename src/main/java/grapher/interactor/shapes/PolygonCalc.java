package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PolygonCalc {

    public static List<PointData> getVertexPoints(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        pointDataList.add(pointStartData);
        pointDataList.add(new PointData(pointFinishData.getX(), pointStartData.getY()));
        pointDataList.add(pointFinishData);
        pointDataList.add(new PointData(pointStartData.getX(), pointFinishData.getY()));

        return pointDataList;
    }

    public static double getPerimeter(List<PointData> pointDataList) {

        List<PointData> lineData = new ArrayList<>();
        PointData prevPointData = null;
        double perimeter = 0;

        for (PointData pointData : pointDataList) {
            if (prevPointData == null) {
                prevPointData = pointData;
                continue;
            }
            lineData.add(prevPointData);
            lineData.add(pointData);
            prevPointData = pointData;
            perimeter += LineCalc.getPerimeter(lineData);
        }
        return perimeter;
    }

    public static List<PointData> getPointsDataOnSurface(int countPoint, double perimeter, List<PointData> pointsData) {

        // TODO: Переделать (код из Rectangle)

        List<PointData> points = new ArrayList<>();

        int excludeSidePoints = 2;
        countPoint -= excludeSidePoints;

        double distance = perimeter / countPoint;

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

            int countPointsOnSide = getCountPointsOnSide(x1, y1, x2, y2, perimeter, countPoint);

            double directionX = Math.signum(x2 - x1);
            double directionY = Math.signum(y2 - y1);

            points.add(new PointData(xx,yy));

            for (int indexPointOnSide = 0; indexPointOnSide < countPointsOnSide; indexPointOnSide++) {
                xx += distance * directionX;
                yy += distance * directionY;
                PointData point = new PointData(xx, yy);
                points.add(point);
            }

        }
        return points;
    }

    private static int getCountPointsOnSide(double x1, double y1, double x2, double y2, double perimeter, int countPoint) {

        double lengthX = Math.abs(x2 - x1);
        double lengthY = Math.abs(y2 - y1);
        double xMultiply = perimeter / lengthX;
        double yMultiply = perimeter / lengthY;
        int countPointsX = (int) Math.floor(countPoint / xMultiply);
        int countPointsY = (int) Math.floor(countPoint / yMultiply);

        int countPointsOnSide = (countPointsX >= countPointsY) ? countPointsX : countPointsY;

        return countPointsOnSide;
    }

    private static boolean isPointInRange(int maxIndex, int currentIndex) {
        return currentIndex + 1 <= maxIndex - 1;
    }

}
