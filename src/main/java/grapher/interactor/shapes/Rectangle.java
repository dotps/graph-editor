package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;
import grapher.utils.debug;

import java.util.ArrayList;
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

    public List<PointData> getPointsDataForMorph(int countPoint) {
        return RectangleCalc.getPointsDataOnCurve(countPoint, getPerimeter(), getData().getPoints());
    }

    @Override
    public int getPerimeter() {
        return RectangleCalc.getPerimeter(getData().getPoints());
    }
}
