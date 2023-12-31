package grapher;

import grapher.interactor.services.draw.DrawService;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.services.factory.IShapeFactory;
import grapher.interactor.services.factory.ShapeFactory;
import grapher.interactor.services.morphing.IMorphingService;
import grapher.interactor.services.morphing.MorphingService;
import grapher.interactor.services.ui.IUIFactory;
import grapher.presentation.ui.UIFactoryJavaFX;
import grapher.interactor.services.input.IInputService;
import grapher.interactor.services.input.InputService;
import grapher.interactor.services.saveload.ISaveLoadService;
import grapher.interactor.services.saveload.SaveLoadService;
import grapher.interactor.services.ui.IUIService;
import grapher.interactor.services.ui.UIService;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {

        IDrawService drawService = new DrawService();
        IShapeFactory shapeFactory = new ShapeFactory();
        ISaveLoadService saveLoadService = new SaveLoadService(shapeFactory, drawService);
        IMorphingService morphingService = new MorphingService(drawService);
        IInputService inputService = new InputService(drawService, saveLoadService, shapeFactory, morphingService);
        IUIFactory uiFactory = new UIFactoryJavaFX(stage, inputService);
        IUIService uiService = new UIService(uiFactory);

        uiService.createUI();
        inputService.injectUIService(uiService);

//        inputService.setCanvas(uiFactory.getCanvas());

    }

    public static void main(String[] args) {
        launch();
    }
}