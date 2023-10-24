package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int getMaxCountPointOnShape(int countPoint) {
        return countPoint > 360 ? 360 : countPoint;
    }

    public static List<PointData> sortPointsFromLeftCorner(List<PointData> pointsData) {

        List<PointData> sortedPointsData = new ArrayList<>();
        int indexLeftPoint = getIndexLeftPoint(pointsData);

        debug.log("indexLeftPoint " + indexLeftPoint);

        if (indexLeftPoint == 0)
            return pointsData;

        int countPoints = pointsData.size();
        int lastIndexPoint = countPoints - 1;

        if (isShapeClockwise(pointsData, countPoints)) {
            for (int i = indexLeftPoint; i < countPoints; i++)
                sortedPointsData.add(pointsData.get(i));
            for (int i = 0; i < indexLeftPoint; i++)
                sortedPointsData.add(pointsData.get(i));
        } else {
            for (int i = indexLeftPoint; i >= 0; i--)
                sortedPointsData.add(pointsData.get(i));
            for (int i = lastIndexPoint; i > indexLeftPoint; i--)
                sortedPointsData.add(pointsData.get(i));
        }

        return sortedPointsData;
    }

    private static boolean isShapeClockwise(List<PointData> pointsData, int countPoints) {
        double sumArea = 0;
        for (int i = 0; i < countPoints; ++i) {
            PointData currentPoint = pointsData.get(i);
            PointData nextPoint = pointsData.get((i + 1) % countPoints);
            double vectorArea = currentPoint.getX() * nextPoint.getY() - currentPoint.getY() * nextPoint.getX();
            sumArea += vectorArea;
        }
        return sumArea > 0;
    }

    private static int getIndexLeftPoint(List<PointData> pointsData) {

        int index = 0;
        double leftX = pointsData.get(index).getX();

        for (int i = 0; i < pointsData.size(); i++) {
            debug.log(pointsData.get(i).getX() + " " + pointsData.get(i).getY() + " " + i);
            if (pointsData.get(i).getX() < leftX) {
                leftX = pointsData.get(i).getX();
                index = i;
            }
        }
        return index;
    }
}
