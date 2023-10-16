package grapher.interactor.services.draw.strategies;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;
import javafx.scene.paint.Color;

public class DrawPoint implements IDrawStrategy {
    @Override
    public void draw(IShape shape, ICanvas canvas) {
        PointData pointData = shape.getFirstPointData();
        canvas.addLine(pointData.getX(), pointData.getY(), pointData.getX(), pointData.getY(), Color.RED, 5);
    }
}
