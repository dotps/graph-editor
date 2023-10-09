package grapher.interactor.services.draw.strategies;

import grapher.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

import java.util.List;

public class DrawEllipse implements IDrawStrategy {

    static final int INDEX_POINT = 0;
    static final int INDEX_RADIUS = 1;
    static final int COUNT_POINT_FOR_ELLIPSE = 2;

    @Override
    public void draw(IShape shape, ICanvas drawArea) {

        List<PointData> pointDataList = shape.getAllPointsData();
        if (pointDataList.size() != COUNT_POINT_FOR_ELLIPSE) {
            debug.error("DRAW. Неверные данные. Фигура должна содержать 2 точки.");
            return;
        }

        PointData center = pointDataList.get(INDEX_POINT);
        double radiusX = pointDataList.get(INDEX_RADIUS).x;
        double radiusY = pointDataList.get(INDEX_RADIUS).y;

        drawArea.addEllipse(center.x, center.y, radiusX, radiusY);

        debug.log("DRAW " + shape.getClass().getName());
    }
}
