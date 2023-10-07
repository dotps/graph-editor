package grapher;

import grapher.interactor.services.factory.UIFactoryJavaFX;
import grapher.interactor.services.ui.IUIService;
import grapher.interactor.services.ui.UIService;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
//        stage.setTitle("Graph Editor");
//
//        stage.setScene(scene);
//        stage.show();

        stage.setTitle("Graph Editor");

        /*
        Label label = new Label("Not clicked");
        Button button = new Button("Click");

        button.setOnAction(value ->  {
            label.setText("Clicked!");
        });

        */

        IUIService uiService = new UIService(new UIFactoryJavaFX());
        uiService.createShapesMenu();

        //IUIFactory uiFactory = new UIJavaFXFactory();
        //Button button = uiFactory.createButton("TEST");
        //uiFactory.createShapesMenu();

        //HBox hbox = uiFactory.createShapesMenu();

        /*
        Scene scene = new Scene(hbox, 1000, 800);
        stage.setScene(scene);
        stage.show();
*/
    }

    public static void main(String[] args) {
        launch();
    }
}