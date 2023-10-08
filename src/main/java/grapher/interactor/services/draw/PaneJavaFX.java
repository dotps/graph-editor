package grapher.interactor.services.draw;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class PaneJavaFX extends Pane implements ICanvas {

    public PaneJavaFX() {
        setMaxSize(1000, 700);
        setStyle("-fx-border-width: 5; -fx-border-color: gray;");
    }

    @Override
    public void add(Shape shape) {
        this.getChildren().add(shape);
    }
}
