package grapher.interactor.shapes;

import grapher.data.PointData;
import grapher.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;

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
}
