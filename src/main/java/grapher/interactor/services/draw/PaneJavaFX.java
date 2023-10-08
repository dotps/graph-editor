package grapher.interactor.services.draw;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class PaneJavaFX extends Pane implements ICanvas {

    @Override
    public void addLine(Shape shape) {
        this.getChildren().add(shape);
    }
}
