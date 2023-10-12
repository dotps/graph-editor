package grapher.interactor.services.draw;

import grapher.interactor.services.IService;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Point;

import java.util.List;

public interface IDrawService extends IService {
    void draw(IShape shape, ICanvas canvas);
    void clearCanvas(ICanvas canvas);
    List<IShape> getShapesOnCanvas();
    void drawText(String text, Point point, ICanvas canvas);
}
