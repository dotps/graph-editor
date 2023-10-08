package grapher.interactor.services.factory;

import grapher.data.PointData;
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
    private Shapes selectedShape = Shapes.Line;

    private Point start;
    private Point finish;
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

    public HBox createShapesMenu()
    {
        HBox hBox = new HBox();
        for (Shapes shape : Shapes.values()) {
            Button button = createButton(shape.name());
            button.setOnAction((event) -> {
                selectedShape = shape;
            });
            hBox.getChildren().add(button);
        }

        return hBox;
    }

    @Override
    public void createUI() {

        StackPane root = new StackPane();

        //Canvas canvas = createCanvas();
        Pane drawArea = createDrawArea();
        inputService.setDrawArea(drawArea);

        HBox shapesBox = createShapesMenu();

        root.getChildren().add(shapesBox);
        //root.getChildren().add(canvas);
        root.getChildren().add(drawArea);

        Scene scene = new Scene(root, 1000, 800);
        stage.setTitle("Graph Editor");
        stage.setScene(scene);
        stage.show();
    }

    private Pane createDrawArea() {

        Pane drawArea = new Pane();

        drawArea.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            debug.log("MOUSE_PRESSED drawArea");
            startPointData = new PointData(event.getX(), event.getY());
        });

        drawArea.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            debug.log("MOUSE_RELEASED drawArea");
            finish = new Point(event.getX(), event.getY());
            finishPointData = new PointData(event.getX(), event.getY());
            IShape shape = inputService.inputShapesHandler(startPointData, finishPointData, selectedShape);

            //Line line = new Line(startPointData.x, startPointData.y, finishPointData.x, finishPointData.y);
            //drawArea.getChildren().add(line);

            startPointData = null;
            finishPointData = null;
        });

        drawArea.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

        });

        return drawArea;
    }

    private Canvas createCanvas() {
        Canvas canvas = new Canvas(1000, 700);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        initDraw(graphicsContext);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
            event -> {
                debug.log("MOUSE_PRESSED");
                //start = new Point(event.getX(), event.getY());
                startPointData = new PointData(event.getX(), event.getY());
                //graphicsContext.beginPath();
                //graphicsContext.moveTo(event.getX(), event.getY());
                //graphicsContext.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
            event -> {
                //debug.log("MOUSE_DRAGGED");

                //graphicsContext.lineTo(event.getX(), event.getY());
                //graphicsContext.stroke();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
            event -> {
                debug.log("MOUSE_RELEASED");
                finish = new Point(event.getX(), event.getY());
                finishPointData = new PointData(event.getX(), event.getY());
                IShape shape = inputService.inputShapesHandler(startPointData, finishPointData, selectedShape);

                //graphicsContext.strokeLine();



                startPointData = null;
                finishPointData = null;
                //finish = null;
                //start = null;
        });

        return canvas;
    }

    private void initDraw(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

    }

    public Stage getStage() {
        return stage;
    }

/*
    @Override
    public IShape createShape(ShapeData shapeData) {

        switch (shapeData.shapeType) {
            case Point:
                Point point = createPoint(0,0);
                point.setData(shapeData);
                return point;
            case Line:
                Line line = createLine(createPoint(0,0), createPoint(0,0));
                line.setData(shapeData);
                return line;
            case Rectangle:
                Rectangle rect = createRect(createPoint(0,0), createPoint(0,0));
                rect.setData(shapeData);
                return rect;
            case Ellipse:
                Point radius = createPoint(0,0);
                Ellipse ellipse = createEllipse(createPoint(0, 0), radius);
                ellipse.setData(shapeData);
                return ellipse;
            case Star:
                return null;
            default:
                return null;
        }
    }

    public Point createPoint(double x, double y) {
        return new Point(x, y);
    }

    public Line createLine(Point pointStart, Point pointFinish) {
        return new Line(pointStart, pointFinish);
    }

    public Rectangle createRect(Point pointStart, Point pointFinish) {
        return new Rectangle(pointStart, pointFinish);
    }

    public Ellipse createEllipse(Point centerPoint, Point radius) {
        return new Ellipse(centerPoint, radius);
    }

 */
}
