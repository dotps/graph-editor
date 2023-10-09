package grapher.interactor.services.draw.strategies;

import grapher.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
//import grapher.interactor.shapes.Line;
import grapher.utils.debug;

import java.util.List;
import javafx.scene.shape.Line;

public class DrawLine implements IDrawStrategy {

    private Boolean isClosed = false;

    public DrawLine(Boolean isClosed) {

        this.isClosed = isClosed;
    }

    public DrawLine() {

    }

    @Override
    public void draw(IShape shape, ICanvas drawArea) {

        debug.log("DRAW " + shape.getClass().getName());

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
            drawArea.addLine(prevPointData.x, prevPointData.y, pointData.x, pointData.y);
            prevPointData = pointData;
        }

        if (isClosed) {
            drawArea.addLine(prevPointData.x, prevPointData.y, startPointData.x, startPointData.y);
        }
    }
}
