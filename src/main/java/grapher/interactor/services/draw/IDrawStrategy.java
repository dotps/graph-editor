package grapher.interactor.services.draw;


import grapher.interactor.shapes.IShape;
import javafx.scene.layout.Pane;

public interface IDrawStrategy {
    void draw(IShape shape, ICanvas drawArea);
}
