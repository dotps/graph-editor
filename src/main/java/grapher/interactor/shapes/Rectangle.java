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

        List<PointData> pointsData = getAllPointsData();

        int diffCount = countPoint - pointsData.size();
        debug.log("diffCount " + diffCount);

        for (PointData pointData : pointsData) {
            debug.log(pointData.x + " " + pointData.y);
        }
        debug.log("===");

        while (diffCount > 0) {
            debug.log(diffCount);
            PointData pointData1 = pointsData.get(diffCount);
            PointData pointData2 = pointsData.get(diffCount+1);

            double x = pointData1.x - (pointData1.x - pointData2.x) / 2;
            double y = pointData1.y - (pointData1.y - pointData2.y) / 2;

            debug.log(pointData1.x + " " + pointData1.y);
            debug.log(pointData2.x + " " + pointData2.y);
            debug.log(x + " insert " + diffCount+1 + " << " + y);
            debug.log("---");

            pointsData.add(diffCount + 1, new PointData(x, y));

            diffCount--;
        }

        debug.log("*****");
        for (PointData pointData : pointsData) {
            debug.log(pointData.x + " " + pointData.y);
        }

        return pointsData;

//        int i = 1;
//        for (int i = 0; i <= pointsData.size() - 1; i++) {
//        for (PointData pointData : pointsData) {

//            debug.log(pointsData.get(i));

//            if (i > diffCount)
//                break;
//            i++;
//        }


//        int shapePointCount = getData().points.size();
//        if (shapePointCount == countPoint)
//            return getAllPointsData();
////        else if (shapePointCount < countPoint)
//            //
////
//
//        return null;
    }
}
