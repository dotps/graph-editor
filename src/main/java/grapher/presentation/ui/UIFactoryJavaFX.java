package grapher.presentation.ui;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.presentation.draw.CanvasPane;
import grapher.interactor.services.input.IInputService;
import grapher.interactor.shapes.Shapes;
import grapher.interactor.services.ui.IUIFactory;
import grapher.utils.debug;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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

        createActionMenu(hBox);

        return hBox;
    }

    public void createActionMenu(HBox hBox) {

        Button button = createButton("Morphing");
        hBox.getChildren().add(button);

        button = createButton("Save");
        button.setOnAction((event) -> inputService.saveShapesHandler());
        hBox.getChildren().add(button);

        button = createButton("Load");
        button.setOnAction((event) -> inputService.loadShapesHandler());
        hBox.getChildren().add(button);

        button = createButton("Clear");
        button.setOnAction((event) -> inputService.clearCanvasHandler());
        hBox.getChildren().add(button);
    }

    @Override
    public void createUI() {

        StackPane root = new StackPane();
        HBox menu = createShapesMenu();

        CanvasPane canvas = createCanvas();
        inputService.setCanvas(canvas);

        root.getChildren().add(menu);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Graph Editor");
        stage.setScene(scene);
        stage.show();
    }

    private CanvasPane createCanvas() {

        CanvasPane canvas = new CanvasPane();

        initMousePressed(canvas);
        initMouseReleased(canvas);
        initMouseDragged(canvas);

        return canvas;
    }

    private void initMousePressed(CanvasPane canvas) {
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            debug.log("MOUSE_PRESSED canvas");
            startPointData = new PointData(event.getX(), event.getY());
        });
    }

    private void initMouseReleased(CanvasPane canvas) {
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            debug.log("MOUSE_RELEASED canvas");
            finishPointData = new PointData(event.getX(), event.getY());
            inputService.inputShapesHandler(startPointData, finishPointData, selectedShape);
            startPointData = null;
            finishPointData = null;
        });
    }

    private static void initMouseDragged(CanvasPane canvas) {
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

        });
    }
}
