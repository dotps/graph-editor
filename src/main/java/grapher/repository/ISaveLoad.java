package grapher.repository;
import grapher.data.ShapeData;

public interface ISaveLoad {
    boolean saveShapeData(ShapeData data);
    ShapeData loadShapeData();
}
