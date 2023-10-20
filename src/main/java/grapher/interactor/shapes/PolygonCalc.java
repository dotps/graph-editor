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

    private static boolean isPointInRange(int maxIndex, int currentIndex) {
        return currentIndex + 1 <= maxIndex - 1;
    }

}
