package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class Line extends Shape {
    public Line(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = new ArrayList<>();
        pointDataList.add(pointStart.getFirstPointData());
        pointDataList.add(pointFinish.getFirstPointData());

        setData(new ShapeData(pointDataList, Shapes.Line));
        injectDrawStrategy();
    }

    public Line() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawLine());
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {
        return LineCalc.getPointsDataOnCurve(countPoint, getPerimeter(), getData().getPoints());
    }

    @Override
    public int getPerimeter() {
        return LineCalc.getPerimeter(getData().getPoints());
    }
}
