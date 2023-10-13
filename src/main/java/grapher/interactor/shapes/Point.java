package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawPoint;

import java.util.ArrayList;
import java.util.List;

public class Point extends Shape {

    public Point(double x, double y) {

        List<PointData> pointDataList = new ArrayList<>();
        pointDataList.add(new PointData(x,y));

        setData(new ShapeData(pointDataList, Shapes.Point));
        injectDrawStrategy();
    }

    public Point() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawPoint());
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {
        return null;
    }

    @Override
    public int getPerimeter() {
        return 1;
    }

    public static PointData diffData(PointData pointDataStart, PointData pointDataFinish) {
        double newX = Math.abs(pointDataStart.getX() - pointDataFinish.getX());
        double newY = Math.abs(pointDataStart.getY() - pointDataFinish.getY());
        return new PointData(newX, newY);
    }

}
