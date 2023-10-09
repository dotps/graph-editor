package grapher.interactor.services.draw.strategies;

import grapher.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawStrategy;
import grapher.interactor.shapes.IShape;
import grapher.utils.debug;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class DrawPoint implements IDrawStrategy {
    @Override
    public void draw(IShape shape, ICanvas drawArea) {

        debug.log("DRAW " + shape.getClass().getName());

        PointData pointData = shape.getFirstPointData();
        drawArea.addLine(pointData.x, pointData.y, pointData.x, pointData.y);
    }
}
