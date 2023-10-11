package grapher.interactor.services.saveload;

import grapher.interactor.data.ShapeData;
import grapher.interactor.services.IService;
import grapher.interactor.shapes.IShape;

import java.util.List;

public interface ISaveLoadService extends IService {
    void save();
    List<IShape> load();
}
