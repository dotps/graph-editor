package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;

import java.util.List;

public class Rectangle extends Polygon {
    public Rectangle(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = RectangleCalc.getVertexPoints(pointStart.getFirstPointData(), pointFinish.getFirstPointData());
        pointDataList = PolygonCalc.sortPointsFromLeftTopCorner(pointDataList);

        setData(new ShapeData(pointDataList, Shapes.Rectangle));
        injectDrawStrategy();
    }
}
