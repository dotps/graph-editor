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

    @Override
    public void draw(IShape shape, ICanvas drawArea) {
        debug.log("DRAW " + shape.getClass().getName());

        PointData startPointData = null;

        List<PointData> pointDataList = shape.getAllPointsData();

        for (PointData pointData : pointDataList) {
            if (startPointData == null) {
                startPointData = pointData;
                continue;
            }
            Line line = new Line(startPointData.x, startPointData.y, pointData.x, pointData.y);
            drawArea.add(line);
            startPointData = null;
        }

        //pointDataList.forEach(pointData -> {
        //    debug.log("X " + pointData.x + ", Y " + pointData.y);
        //});


    }
}
