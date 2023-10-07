package grapher.interactor.services.draw.strategies;

import grapher.data.PointData;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;
import java.util.List;

public class DrawLine implements IDrawStrategy {
    @Override
    public void draw(IShape shape) {
        debug.log("DRAW " + shape.getClass().getName());
        List<PointData> pointDataList = shape.getAllPointsData();
        pointDataList.forEach(pointData -> {
            debug.log("X " + pointData.x + ", Y " + pointData.y);
        });
    }
}
