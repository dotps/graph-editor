package grapher;

import grapher.interactor.services.factory.UIFactoryJavaFX;
import grapher.interactor.services.ui.IUIService;
import grapher.interactor.services.ui.UIService;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        IUIService uiService = new UIService(new UIFactoryJavaFX(stage));
        uiService.showUI();
    }

    public static void main(String[] args) {
        launch();
    }
}