package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;
import grapher.utils.debug;

import java.util.List;

public class Rectangle extends Shape {
    public Rectangle(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = RectangleCalc.getVertexPoints(pointStart.getFirstPointData(), pointFinish.getFirstPointData());

        setData(new ShapeData(pointDataList, Shapes.Rectangle));
        injectDrawStrategy();

    }

    public Rectangle() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawLine(true));
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {

        // x = x0 * cosθ − y0 * sinθ
        // y = x0 * sinθ + y0 * cos

        List<PointData> pointsData = getAllPointsData();

        int diffCount = countPoint - pointsData.size();
        debug.log("diffCount " + diffCount);

        for (PointData pointData : pointsData) {
            debug.log(pointData.getX() + " " + pointData.getY());
        }
        debug.log("===");

        while (diffCount > 0) {
            debug.log(diffCount);
            PointData pointData1 = pointsData.get(diffCount);
            PointData pointData2 = pointsData.get(diffCount+1);

            double x = pointData1.getX() - (pointData1.getX() - pointData2.getX()) / 2;
            double y = pointData1.getY() - (pointData1.getY() - pointData2.getY()) / 2;

            debug.log(pointData1.getX() + " " + pointData1.getY());
            debug.log(pointData2.getX() + " " + pointData2.getY());
            debug.log(x + " insert " + diffCount+1 + " << " + y);
            debug.log("---");

            pointsData.add(diffCount + 1, new PointData(x, y));

            diffCount--;
        }

        debug.log("*****");
        for (PointData pointData : pointsData) {
            debug.log(pointData.getX() + " " + pointData.getY());
        }

        return pointsData;
    }
}
