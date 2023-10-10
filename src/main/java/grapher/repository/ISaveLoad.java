package grapher.repository;
import grapher.interactor.data.ShapeData;

import java.util.List;

public interface ISaveLoad {
    boolean saveShapeData(ShapeData data);
    ShapeData loadShapeData();
    boolean save(List<ShapeData> shapesData);

    List<ShapeData> load();
}
