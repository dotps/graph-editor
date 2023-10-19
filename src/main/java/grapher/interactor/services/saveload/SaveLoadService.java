package grapher.interactor.services.saveload;

import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.services.factory.IShapeFactory;
import grapher.interactor.shapes.IShape;
import grapher.repository.FileSaveLoad;
import grapher.repository.ISaveLoad;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class SaveLoadService implements ISaveLoadService {
    private final IShapeFactory shapeFactory;
    private final IDrawService drawService;
    private final ISaveLoad saveLoad = new FileSaveLoad();

    public SaveLoadService(IShapeFactory shapeFactory, IDrawService drawService) {
        this.shapeFactory = shapeFactory;
        this.drawService = drawService;
    }

    @Override
    public void save() {
        List<IShape> shapes = drawService.getShapesOnCanvas();
        List<ShapeData> shapesData = new ArrayList<>();

        for (IShape shape : shapes) {
            shapesData.add(shape.getData());
            debug.log("shape.save");
            debug.log(shape);
        }

        if (saveLoad.save(shapesData))
            debug.log("SAVED CANVAS");
    }

    @Override
    public List<IShape> load() {

        List<ShapeData> shapesData = saveLoad.load();
        List<IShape> shapes = new ArrayList<>();

        for (ShapeData shapeData : shapesData) {
            IShape shape = shapeFactory.createShape(shapeData);
            shapes.add(shape);
        }

        debug.log("LOADED");
        return shapes;
    }
}
