package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
//import grapher.interactor.shapes.Line;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawLine implements IDrawStrategy {

    public static final int MIN_POINT_FOR_DRAW = 2;

    @Override
    public void draw(IShape shape, ICanvas canvas) {

        List<PointData> pointDataList = shape.getAllPointsData();

        if (pointDataList.size() < MIN_POINT_FOR_DRAW)
            return;

        PointData prevPointData = null;

        for (PointData pointData : pointDataList) {
            if (prevPointData == null) {
                prevPointData = pointData;
                continue;
            }
            canvas.addLine(prevPointData.getX(), prevPointData.getY(), pointData.getX(), pointData.getY(), Color.BLACK, 1);
            prevPointData = pointData;
        }
    }
}
