package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class EllipseCalc {

    public static List<PointData> getProperties(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        double lengthSideX = pointFinishData.getX() - pointStartData.getX();
        double lengthSideY = pointFinishData.getY() - pointStartData.getY();
        double radiusX = Math.abs(lengthSideX / 2);
        double radiusY = Math.abs(lengthSideY / 2);
        double x = pointStartData.getX() + lengthSideX / 2;
        double y = pointStartData.getY() + lengthSideY / 2;

        pointDataList.add(new PointData(x, y));
        pointDataList.add(new PointData(radiusX, radiusY));

        return pointDataList;
    }

    public static List<PointData> getPointsDataOnSurface(int countPoint, PointData center, PointData radius) {

        List<PointData> pointsData = new ArrayList<>();
        double maxRotationAngle = 360.0;
        int offsetAngle = -135;

        countPoint = Calc.getMaxCountPointOnShape(countPoint);

        double angleRotation = maxRotationAngle / countPoint;
        double anglePoint = offsetAngle;
        double i = 0;
        while (i < countPoint) {
            double x = center.getX() + radius.getX() * Math.sin(Math.toRadians(anglePoint));
            double y = center.getY() + radius.getY() * Math.cos(Math.toRadians(anglePoint));
            pointsData.add(new PointData(x,y));
            anglePoint -= angleRotation;
            i++;
        }
        return pointsData;
    }

    public static double getPerimeter(PointData radius) {
        double perimeter = Math.floor(2 * Math.PI * Math.sqrt((Math.pow(radius.getX(), 2) + Math.pow(radius.getY(), 2)) / 2));
        return perimeter;
    }
}
