package grapher.interactor.services.factory;

import grapher.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.PaneJavaFX;
import grapher.interactor.services.input.IInputService;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Point;
import grapher.interactor.shapes.Shapes;
import grapher.utils.debug;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class UIFactoryJavaFX implements IUIFactory {
    private final Stage stage;
    private final IInputService inputService;
    private Shapes selectedShape = Shapes.Point;
    private PointData startPointData;
    private PointData finishPointData;

    public UIFactoryJavaFX(Stage stage, IInputService inputService) {
        this.stage = stage;
        this.inputService = inputService;
    }

    public Button createButton(String title) {
        Button button = new Button(title);
        button.setMaxSize(100, 30);
        return button;
    }

    public HBox createShapesMenu() {
        HBox hBox = new HBox();
        for (Shapes shapeType : Shapes.values()) {
            Button button = createButton(shapeType.name());
            button.setOnAction((event) -> selectedShape = shapeType);
            hBox.getChildren().add(button);
        }
        return hBox;
    }

    @Override
    public void createUI() {

        StackPane root = new StackPane();
        HBox shapesBox = createShapesMenu();

        PaneJavaFX drawArea = createDrawArea();
        inputService.setDrawArea(drawArea);

        root.getChildren().add(shapesBox);
        root.getChildren().add(drawArea);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Graph Editor");
        stage.setScene(scene);
        stage.show();
    }

    private PaneJavaFX createDrawArea() {

        PaneJavaFX drawArea = new PaneJavaFX();

        drawArea.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            debug.log("MOUSE_PRESSED drawArea");
            startPointData = new PointData(event.getX(), event.getY());
        });

        drawArea.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            debug.log("MOUSE_RELEASED drawArea");
            finishPointData = new PointData(event.getX(), event.getY());
            IShape shape = inputService.inputShapesHandler(startPointData, finishPointData, selectedShape);

            startPointData = null;
            finishPointData = null;
        });

        drawArea.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

        });

        return drawArea;
    }
}
