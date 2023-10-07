package grapher.interactor.shapes;

import grapher.data.PointData;
import grapher.data.ShapeData;
import grapher.interactor.services.draw.IDrawStrategy;

import java.util.List;

public interface IShape {
    IDrawStrategy getDrawStrategy();
    PointData getFirstPointData();
    List<PointData> getAllPointsData();
    ShapeData getData();
}
