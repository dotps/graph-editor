package grapher.interactor.services.input;

import grapher.interactor.data.PointData;
import grapher.interactor.services.IService;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.ui.IUIService;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Shapes;

import java.util.List;

public interface IInputService extends IService {
    void inputShapesHandler(PointData start, PointData finish, Shapes shapeType);
    void setCanvas(ICanvas canvas);
    void saveShapesHandler();
    void loadShapesHandler();
    void clearCanvasHandler();
    void startMorphingHandler();
    void morphSliderChanged(double value);
    void inputPolygonHandler(List<PointData> polygonPointData);
    void injectUIService(IUIService uiService);
}
