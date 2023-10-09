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
            debug.error("DRAW. Неверные данные. Фигура дожна содержать 2 точки.");
            return;
        }

        PointData center = pointDataList.get(INDEX_POINT);
        double radiusX = pointDataList.get(INDEX_RADIUS).x;
        double radiusY = pointDataList.get(INDEX_RADIUS).y;

        Ellipse ellipse = new Ellipse(center.x, center.y, radiusX, radiusY);
        ellipse.setStroke(Color.ORANGE);
        ellipse.setFill(null);
        drawArea.add(ellipse);

        debug.log("DRAW " + shape.getClass().getName());
    }
}
