package grapher.interactor.services.factory;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.shapes.*;

public interface IShapeFactory {
    IShape createShape(ShapeData shapeData);
    IShape createShape(PointData start, PointData finish, Shapes shapeType);
    Point createPoint(double x, double y);
    Line createLine(Point pointStart, Point pointFinish);
    Rectangle createRect(Point pointStart, Point pointFinish);
    Ellipse createEllipse(Point pointStart, Point pointFinish);
}
