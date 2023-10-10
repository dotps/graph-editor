package grapher.interactor.services.saveload;

import grapher.interactor.data.ShapeData;
import grapher.interactor.services.factory.IShapeFactory;
import grapher.interactor.shapes.IShape;
import grapher.repository.FileSaveLoad;
import grapher.repository.ISaveLoad;
import grapher.utils.debug;

public class SaveLoadService implements ISaveLoadService {
    private final IShapeFactory shapeFactory;
    private final ISaveLoad saveLoad = new FileSaveLoad();

    public SaveLoadService(IShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public void saveShape(ShapeData data) {
        if (saveLoad.saveShapeData(data))
            debug.log("SAVED " + data);
    }

    public IShape loadShape() {

        ShapeData shapeData = saveLoad.loadShapeData();
        IShape shape = shapeFactory.createShape(shapeData);
        debug.log("LOADED");

        return shape;
    }


}
