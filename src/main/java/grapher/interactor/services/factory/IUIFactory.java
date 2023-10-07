package grapher.interactor.services.factory;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public interface IUIFactory {
    Button createButton(String title);
    HBox createShapesMenu();
}
