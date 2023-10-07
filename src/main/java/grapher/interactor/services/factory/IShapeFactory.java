package grapher.interactor.services.factory;

import grapher.data.ShapeData;
import grapher.interactor.shapes.*;

public interface IShapeFactory {
    IShape createShape(ShapeData shapeData);
    Point createPoint(double x, double y);
    Line createLine(Point pointStart, Point pointFinish);
    Rectangle createRect(Point pointStart, Point pointFinish);
    Ellipse createEllipse(Point centerPoint, Point radius);
}
