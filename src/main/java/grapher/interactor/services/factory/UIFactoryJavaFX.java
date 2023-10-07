package grapher.interactor.services.factory;

import grapher.interactor.shapes.Shapes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UIFactoryJavaFX implements IUIFactory {

    private final Stage stage;

    public UIFactoryJavaFX(Stage stage) {
        this.stage = stage;
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
            System.out.println(shape);
            Button button = createButton(shape.name());
            hBox.getChildren().add(button);
        }

        return hBox;
    }

    @Override
    public void createUI() {
        stage.setTitle("Graph Editor");

        HBox hbox = createShapesMenu();

        Scene scene = new Scene(hbox, 1000, 800);
        stage.setScene(scene);
        stage.show();
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
