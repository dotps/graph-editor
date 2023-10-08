package grapher.interactor.services.input;

import grapher.data.PointData;
import grapher.interactor.services.IService;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Shapes;
import javafx.scene.layout.Pane;

public interface IInputService extends IService {
    void inputShapesHandler();
    IShape inputShapesHandler(PointData start, PointData finish, Shapes shapeType);

    void setDrawArea(Pane drawArea);
}
