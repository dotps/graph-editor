package grapher.interactor.services.input;

import grapher.interactor.services.IService;
import grapher.interactor.shapes.Point;
import grapher.interactor.shapes.Shapes;

public interface IInputService extends IService {
    void inputShapesHandler();
    void input(Point start, Point finish, Shapes shapeType);
}
