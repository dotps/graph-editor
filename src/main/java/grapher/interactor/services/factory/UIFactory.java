package grapher.interactor.services.factory;

public class UIFactory implements IUIFactory {
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
