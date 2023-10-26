package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawPolygon implements IDrawStrategy {

    public static final int MIN_POINT_FOR_DRAW = 3;

    @Override
    public void draw(IShape shape, ICanvas canvas) {

        List<PointData> pointDataList = shape.getAllPointsData();

        if (pointDataList.size() < MIN_POINT_FOR_DRAW)
            return;

        PointData prevPointData = null;
        PointData startPointData = null;

        int i = 0;
        for (PointData pointData : pointDataList) {
            i++;
            canvas.addText(Integer.toString(i - 1), pointData.getX(), pointData.getY());
            if (prevPointData == null) {
                prevPointData = pointData;
                startPointData = pointData;
                continue;
            }
            canvas.addLine(prevPointData.getX(), prevPointData.getY(), pointData.getX(), pointData.getY(), Color.BLACK, 1);
            prevPointData = pointData;

        }

        canvas.addLine(prevPointData.getX(), prevPointData.getY(), startPointData.getX(), startPointData.getY(), Color.BLACK, 1);
    }
}
