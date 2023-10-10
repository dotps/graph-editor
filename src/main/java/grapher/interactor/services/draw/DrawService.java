package grapher.interactor.services.draw;

import grapher.interactor.shapes.IShape;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class DrawService implements IDrawService {

//    Dictionary<ICanvas,IShape> shapesOnCanvas;
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

}
