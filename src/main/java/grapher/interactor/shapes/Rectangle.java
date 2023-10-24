package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;
import grapher.interactor.services.draw.strategies.DrawPolygon;

import java.util.List;

public class Rectangle extends Shape {
    public Rectangle(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = RectangleCalc.getVertexPoints(pointStart.getFirstPointData(), pointFinish.getFirstPointData());
        // TODO: sortPointsFromLeftCorner плохо работает для прямоугольника, проверить
//        pointDataList = Calc.sortPointsFromLeftCorner(pointDataList);

        setData(new ShapeData(pointDataList, Shapes.Rectangle));
        injectDrawStrategy();
    }

    public Rectangle() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawPolygon());
    }

    public List<PointData> getPointsDataForMorph(int countPoint) {
        double perimeter = getPerimeter();
        countPoint = normalizeCountPoint(countPoint, perimeter);
        return PolygonCalc.getPointsDataOnSurface(countPoint, perimeter, getData().getPoints());
    }

    @Override
    public double getPerimeter() {
        return PolygonCalc.getPerimeter(getData().getPoints());
    }
}
