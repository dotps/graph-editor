package grapher.presentation.draw;

import grapher.interactor.services.draw.ICanvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

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
    public void addEllipse(double centerX, double centerY, double radiusX, double radiusY) {
        Ellipse ellipse = new Ellipse(centerX, centerY, radiusX, radiusY);
        ellipse.setStroke(Color.ORANGE);
        ellipse.setFill(null);
        add(ellipse);
    }

    @Override
    public void addLine(double startX, double startY, double finishX, double finishY) {
        Line line = new Line(startX, startY, finishX, finishY);
        add(line);
    }
}
