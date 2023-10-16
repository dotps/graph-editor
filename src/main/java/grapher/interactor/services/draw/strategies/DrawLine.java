package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
//import grapher.interactor.shapes.Line;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawLine implements IDrawStrategy {

    private Boolean isClosed = false;
    public DrawLine(Boolean isClosed) {

        this.isClosed = isClosed;
    }

    public DrawLine() {

    }

    @Override
    public void draw(IShape shape, ICanvas canvas) {

        List<PointData> pointDataList = shape.getAllPointsData();

        if (pointDataList.size() < 2)
            return;

        PointData prevPointData = null;
        PointData startPointData = null;

        for (PointData pointData : pointDataList) {
            if (prevPointData == null) {
                prevPointData = pointData;
                startPointData = pointData;
                continue;
            }
            canvas.addLine(prevPointData.getX(), prevPointData.getY(), pointData.getX(), pointData.getY(), Color.BLACK, 1);
            prevPointData = pointData;
        }

        if (isClosed) {
            canvas.addLine(prevPointData.getX(), prevPointData.getY(), startPointData.getX(), startPointData.getY(), Color.BLACK, 1);
        }
    }
}
