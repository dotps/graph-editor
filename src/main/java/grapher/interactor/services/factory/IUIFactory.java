package grapher.interactor.services.factory;

import grapher.interactor.shapes.Shapes;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public interface IUIFactory {
    Button createButton(String title);
    HBox createShapesMenu();
    void createUI();
}
