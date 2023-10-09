package grapher.interactor.services.draw;

import grapher.interactor.shapes.IShape;
import javafx.scene.shape.Shape;

public interface ICanvas {
    void add(Shape shape);
    void addEllipse(double centerX, double centerY, double radiusX, double radiusY);

    void addLine(double startX, double startY, double finishX, double finishY);
}
