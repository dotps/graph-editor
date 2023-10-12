package grapher.presentation.draw;

import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.shapes.IShape;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class CanvasPane extends Pane implements ICanvas {

    public CanvasPane() {
        setMaxSize(1000, 700);
        setStyle("-fx-border-width: 5; -fx-border-color: gray;");
    }

    @Override
    public void add(Shape shape) {
        this.getChildren().add(shape);
    }

    @Override
    public void addEllipse(double centerX, double centerY, double radiusX, double radiusY, Color color, int width) {
        Ellipse ellipse = new Ellipse(centerX, centerY, radiusX, radiusY);
        ellipse.setStroke(color);
        ellipse.setStrokeWidth(width);
        ellipse.setFill(null);
        add(ellipse);
    }

    @Override
    public void addLine(double startX, double startY, double finishX, double finishY, Color color, int width) {
        Line line = new Line(startX, startY, finishX, finishY);
        line.setStroke(color);
        line.setStrokeWidth(width);
        add(line);
    }

    @Override
    public void clear() {
        getChildren().clear();
    }

    @Override
    public void addText(String message, double x, double y) {
        Text text = new Text();
        text.setText(message);
        text.setX(x);
        text.setY(y);
        add(text);
    }
}
