package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawEllipse implements IDrawStrategy {

    static final int INDEX_POINT = 0;
    static final int INDEX_RADIUS = 1;
    static final int COUNT_POINT_FOR_ELLIPSE = 2;

    @Override
    public void draw(IShape shape, ICanvas canvas) {

        List<PointData> pointDataList = shape.getAllPointsData();
        if (pointDataList.size() != COUNT_POINT_FOR_ELLIPSE) {
            debug.error("DRAW. Неверные данные. Фигура должна содержать 2 точки.");
            return;
        }

        PointData center = pointDataList.get(INDEX_POINT);
        double radiusX = pointDataList.get(INDEX_RADIUS).getX();
        double radiusY = pointDataList.get(INDEX_RADIUS).getY();

        canvas.addEllipse(center.getX(), center.getY(), radiusX, radiusY, Color.BLACK, 1);

        debug.log("DRAW " + shape.getClass().getName());
    }
}
