package grapher.interactor.services.input;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.services.factory.IShapeFactory;
import grapher.interactor.services.saveload.ISaveLoadService;
import grapher.interactor.shapes.*;

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

    public IShape inputShapesHandler(PointData start, PointData finish, Shapes shapeType) {
        IShape shape = shapeFactory.createShape(start, finish, shapeType);
        drawService.draw(shape, canvas);
        return shape;
    }

    @Override
    public void setCanvas(ICanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void inputShapesHandler() {
/*
        Point point = shapeFactory.createPoint(0, 0);

        Line line = shapeFactory.createLine(
            shapeFactory.createPoint(5, 5),
            shapeFactory.createPoint(15,15)
        );

        Rectangle rect = shapeFactory.createRect(
            shapeFactory.createPoint(10,10),
            shapeFactory.createPoint(50,50)
        );

        Ellipse ellipse = shapeFactory.createEllipse(
            shapeFactory.createPoint(10,10),
            shapeFactory.createPoint(100,100)
        );

        //drawService.draw(point);
        debug.log("=====");
        //drawService.draw(line);
        debug.log("=====");
        //drawService.draw(rect);
        debug.log("=====");
        //drawService.draw(ellipse);
        debug.log("=====");
//        drawService.draw(star);

        saveLoadService.saveShape(rect.getData());
        IShape loadedShape = saveLoadService.loadShape();

        //drawService.draw(loadedShape);
*/
    }
}
