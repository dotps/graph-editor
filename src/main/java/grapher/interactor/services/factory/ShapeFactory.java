package grapher.interactor.services.factory;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.shapes.*;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory implements IShapeFactory {

    @Override
    public IShape createShape(ShapeData shapeData) {

        switch (shapeData.getShapeType()) {
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
            case Polygon:
                Polygon polygon = createPolygon();
                polygon.setData(shapeData);
                return polygon;
            //case Star:
            //    return null;
            default:
                return null;
        }
    }

    @Override
    public IShape createShape(PointData start, PointData finish, Shapes shapeType) {

        switch (shapeType) {
            case Point:
                return createPoint(start.getX(), start.getY());
            case Line:
                return createLine(createPoint(start.getX(), start.getY()), createPoint(finish.getX(), finish.getY()));
            case Rectangle:
                return createRect(createPoint(start.getX(), start.getY()), createPoint(finish.getX(), finish.getY()));
            case Ellipse:
                return createEllipse(createPoint(start.getX(), start.getY()), createPoint(finish.getX(), finish.getY()));
            //case Star:
            //    return null;
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
    public Ellipse createEllipse(Point pointStart, Point pointFinish) {
        return new Ellipse(pointStart, pointFinish);
    }

    @Override
    public Polygon createPolygon(List<PointData> pointsData) {
        return new Polygon(pointsData);
    }

    public Polygon createPolygon() {
        return new Polygon();
    }
}
