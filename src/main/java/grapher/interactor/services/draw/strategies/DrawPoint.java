package grapher.interactor.services.draw.strategies;

import grapher.data.PointData;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;

public class DrawPoint implements IDrawStrategy {
    @Override
    public void draw(IShape shape) {
        PointData pointData = shape.getFirstPointData();
        debug.log("DRAW " + shape.getClass().getName());
        debug.log("X " + pointData.x + ", Y " + pointData.y);
    }
}
