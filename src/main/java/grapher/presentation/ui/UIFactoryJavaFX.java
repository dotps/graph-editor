package grapher.presentation.ui;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.presentation.draw.CanvasPane;
import grapher.interactor.services.input.IInputService;
import grapher.interactor.shapes.Shapes;
import grapher.interactor.services.ui.IUIFactory;
import grapher.utils.debug;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
        button.setOnAction((event) -> inputService.startMorphingHandler());
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
//        root.setAlignment(Pos.TOP_CENTER);
        HBox menu = createShapesMenu();

        CanvasPane canvas = createCanvas();
        inputService.setCanvas(canvas);

        Slider slider = createSlider();
        menu.getChildren().add(slider);

        root.getChildren().add(menu);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Graph Editor");
        stage.setScene(scene);
        stage.show();
    }

    private Slider createSlider() {

        Slider slider = new Slider(0.0, 10.0, 0.0);
        slider.setPrefWidth(500);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(2.0);
        slider.setMajorTickUnit(5.0);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.setOnMouseDragged(event -> {
            double position = slider.getValue() / slider.getMax();
            inputService.morphSliderChanged(position);
        });

//        slider.setOnMouseReleased(event -> {
//            double position = slider.getValue() / slider.getMax();
//            inputService.morphSliderChanged(position);
//        });

        return slider;
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
