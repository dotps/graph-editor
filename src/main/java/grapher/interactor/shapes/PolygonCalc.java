package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PolygonCalc {

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

        List<PointData> points = new ArrayList<>();
        List<Integer> countPointsOnSides = getCountPointsOnSide(perimeter, countPoint, pointsData.size());

        PointData prevPointData = null;
        PointData startPointData = null;

        int indexSide = 0;

        for (PointData currentPointData : pointsData) {
            if (prevPointData == null) {
                prevPointData = currentPointData;
                startPointData = currentPointData;
                continue;
            }

            List<PointData> linePoints = getPointsDataOnLine(prevPointData, currentPointData, countPointsOnSides.get(indexSide));
            points.addAll(linePoints);

            prevPointData = currentPointData;
            indexSide++;
        }

        List<PointData> linePoints = getPointsDataOnLine(prevPointData, startPointData, countPointsOnSides.get(indexSide));
        points.addAll(linePoints);

        return points;
    }

    private static List<PointData> getPointsDataOnLine(PointData startPointData, PointData finishPointData, int countPointsOnSide) {
        List<PointData> linePoints = new ArrayList<>();
        linePoints.add(startPointData);
        linePoints.add(finishPointData);
        return LineCalc.getPointsDataOnSurface(countPointsOnSide, linePoints);
    }

    private static List<Integer> getCountPointsOnSide(double perimeter, int countPoint, int countVertex) {

        int currentCountPoint = countPoint;
        int countPointsOnSide = (int) Math.floor(countPoint / countVertex);
        List<Integer> countPointsOnSides = new ArrayList<>();

        for (int i = 0; i < countVertex; i++) {
            currentCountPoint -= countPointsOnSide;

            if (currentCountPoint < countPointsOnSide)
                countPointsOnSide += currentCountPoint;

            countPointsOnSides.add(countPointsOnSide);
        }

        return countPointsOnSides;
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
