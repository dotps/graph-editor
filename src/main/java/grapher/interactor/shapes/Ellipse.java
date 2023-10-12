package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawEllipse;

import java.util.List;

public class Ellipse extends Shape {

    public Ellipse(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = EllipseCalc.getProperties(pointStart.getFirstPointData(), pointFinish.getFirstPointData());

        setData(new ShapeData(pointDataList, Shapes.Ellipse));
        injectDrawStrategy();
    }

    public Ellipse() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawEllipse());
    }

    public PointData getRadius() {
        return getData().points.get(1);
    }
    public PointData getCenter() {
        return getData().points.get(0);
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {
        PointData radius = getRadius();
        PointData center = getCenter();
        return EllipseCalc.getPointsDataOnCurve(countPoint, center, radius);
    }
}
