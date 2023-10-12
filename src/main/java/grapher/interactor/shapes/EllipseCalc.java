package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class EllipseCalc {

    public static List<PointData> getProperties(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        double lengthSideX = pointFinishData.x - pointStartData.x;
        double lengthSideY = pointFinishData.y - pointStartData.y;
        double radiusX = Math.abs(lengthSideX / 2);
        double radiusY = Math.abs(lengthSideY / 2);
        double x = pointStartData.x + lengthSideX / 2;
        double y = pointStartData.y + lengthSideY / 2;

        pointDataList.add(new PointData(x, y));
        pointDataList.add(new PointData(radiusX, radiusY));

        return pointDataList;
    }

    public static List<PointData> getPointsDataOnCurve(int countPoint, PointData center, PointData radius) {

        List<PointData> pointsData = new ArrayList<>();

        int offset = 45;
        int iterationAngle = Math.round(-360 / countPoint);
        double currentAngle = 0;

        for (int i = 0; i < countPoint; i++) {
            currentAngle = iterationAngle * i + iterationAngle - offset;
            double x = center.x + radius.x * Math.sin(Math.toRadians(currentAngle));
            double y = center.y + radius.y * Math.cos(Math.toRadians(currentAngle));
            pointsData.add(new PointData(x,y));
        }

        return pointsData;
    }
}
