package grapher.interactor.services.ui;

import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.shapes.Shapes;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public interface IUIFactory {
    Button createButton(String title);
    HBox createShapesMenu();
    void createUI();

    public ICanvas getCanvas();

    void setCanvas(ICanvas canvas);
}
