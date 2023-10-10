package grapher.repository;
import grapher.interactor.data.ShapeData;

public interface ISaveLoad {
    boolean saveShapeData(ShapeData data);
    ShapeData loadShapeData();
}
