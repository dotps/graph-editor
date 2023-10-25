package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawPolygon;
import grapher.utils.debug;

import java.util.List;

public class Polygon extends Shape {
    public Polygon(List<PointData> pointsData) {
        pointsData = PolygonCalc.sortPointsFromLeftTopCorner(pointsData);
        setData(new ShapeData(pointsData, Shapes.Polygon));
        injectDrawStrategy();
    }

    public Polygon() {
        injectDrawStrategy();
    }

    public void injectDrawStrategy() {
        setDrawStrategy(new DrawPolygon());
    }

    public List<PointData> getPointsDataForMorph(int countPoint) {
        return PolygonCalc.getPointsDataOnSurface(countPoint, getPerimeter(), getData().getPoints());
    }

    @Override
    public double getPerimeter() {
        return PolygonCalc.getPerimeter(getData().getPoints());
    }
}
