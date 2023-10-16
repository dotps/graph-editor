package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;

import java.util.List;

public class Polygon extends Shape {
    public Polygon(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = RectangleCalc.getVertexPoints(pointStart.getFirstPointData(), pointFinish.getFirstPointData());

        setData(new ShapeData(pointDataList, Shapes.Polygon));
        injectDrawStrategy();

    }

    public Polygon() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawLine(true));
    }

    public List<PointData> getPointsDataForMorph(int countPoint) {
        return PolygonCalc.getPointsDataOnCurve(countPoint, getPerimeter(), getData().getPoints());
    }

    @Override
    public int getPerimeter() {
        return PolygonCalc.getPerimeter(getData().getPoints());
    }
}
