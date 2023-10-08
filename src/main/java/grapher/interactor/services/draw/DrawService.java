package grapher.interactor.services.draw;

import grapher.interactor.shapes.IShape;
import javafx.scene.layout.Pane;

public class DrawService implements IDrawService {

    public void draw(IShape shape, ICanvas drawArea) {
        IDrawStrategy drawStrategy = shape.getDrawStrategy();
        drawStrategy.draw(shape, drawArea);
    }

}
