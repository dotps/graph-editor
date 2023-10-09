package grapher.interactor.services.factory;

import grapher.data.PointData;
import grapher.data.ShapeData;
import grapher.interactor.shapes.*;

import java.util.List;

public interface IShapeFactory {
    IShape createShape(ShapeData shapeData);
    IShape createShape(PointData start, PointData finish, Shapes shapeType);
    Point createPoint(double x, double y);
    Line createLine(Point pointStart, Point pointFinish);
    Rectangle createRect(Point pointStart, Point pointFinish);
    //Ellipse createEllipse(Point centerPoint, Point radius);
    Ellipse createEllipse(Point pointStart, Point pointFinish);
}
