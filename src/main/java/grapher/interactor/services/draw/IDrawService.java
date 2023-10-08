package grapher.interactor.services.draw;

import grapher.interactor.services.IService;
import grapher.interactor.shapes.IShape;
import javafx.scene.layout.Pane;

public interface IDrawService extends IService {
    void draw(IShape shape, Pane drawArea);
}
