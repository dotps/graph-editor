package grapher.interactor.services.draw;

import grapher.interactor.data.PointData;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Point;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class DrawService implements IDrawService {

    List<IShape> shapesOnCanvas = new ArrayList<>();

    public void draw(IShape shape, ICanvas canvas) {
        IDrawStrategy drawStrategy = shape.getDrawStrategy();
        drawStrategy.draw(shape, canvas);
        shapesOnCanvas.add(shape);
    }

    @Override
    public void clearCanvas(ICanvas canvas) {
        debug.log("CLEAR SHAPES " + shapesOnCanvas.size());
        shapesOnCanvas.clear();
        canvas.clear();
    }

    @Override
    public List<IShape> getShapesOnCanvas() {
        return shapesOnCanvas;
    }

    @Override
    public void drawText(String text, Point point, ICanvas canvas) {
        PointData pointData = point.getFirstPointData();
        canvas.addText(text, pointData.getX(), pointData.getY());
    }

}
