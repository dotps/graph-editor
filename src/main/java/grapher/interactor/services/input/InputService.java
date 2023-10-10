package grapher.interactor.services.input;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.services.factory.IShapeFactory;
import grapher.interactor.services.saveload.ISaveLoadService;
import grapher.interactor.shapes.*;
import grapher.utils.debug;

import java.util.List;

public class InputService implements IInputService {
    private final IDrawService drawService;
    private final ISaveLoadService saveLoadService;
    private final IShapeFactory shapeFactory;
    private ICanvas canvas;

    public InputService(IDrawService drawService, ISaveLoadService saveLoadService, IShapeFactory shapeFactory) {
        this.drawService = drawService;
        this.saveLoadService = saveLoadService;
        this.shapeFactory = shapeFactory;
    }

    public void inputShapesHandler(PointData start, PointData finish, Shapes shapeType) {
        IShape shape = shapeFactory.createShape(start, finish, shapeType);
        drawService.draw(shape, canvas);
    }

    @Override
    public void setCanvas(ICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void saveShapesHandler() {
        /*
        Rectangle rect = shapeFactory.createRect(
            shapeFactory.createPoint(10,10),
            shapeFactory.createPoint(50,50)
        );
        saveLoadService.saveShape(rect.getData());
         */
        saveLoadService.save();
    }

    @Override
    public void loadShapesHandler() {
        drawService.clearCanvas(canvas);
        List<IShape> loadedShapes = saveLoadService.load();

        for (IShape shape : loadedShapes) {
            drawService.draw(shape, canvas);
        }

        /*
        IShape loadedShape = saveLoadService.loadShape();
        drawService.draw(loadedShape, canvas);
         */
    }

    @Override
    public void clearCanvasHandler() {
        drawService.clearCanvas(canvas);
    }
}
