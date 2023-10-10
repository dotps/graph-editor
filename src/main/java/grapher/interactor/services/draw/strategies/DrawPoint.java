package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;

public class DrawPoint implements IDrawStrategy {
    @Override
    public void draw(IShape shape, ICanvas canvas) {

        debug.log("DRAW " + shape.getClass().getName());

        PointData pointData = shape.getFirstPointData();
        canvas.addLine(pointData.x, pointData.y, pointData.x, pointData.y);
    }
}
