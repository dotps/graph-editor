package grapher.interactor.data;

import java.io.Serializable;
import java.util.List;
import grapher.interactor.shapes.Shapes;

public class ShapeData implements Serializable {
    private final List<PointData> points;
    private final Shapes shapeType;

    public ShapeData(List<PointData> points, Shapes shapeType) {
        this.points = points;
        this.shapeType = shapeType;
    }

    @Override
    public String toString() {
        return "ShapeData{" +
                "points=" + getPoints() +
                ", shapeType=" + getShapeType() +
                '}';
    }

    public List<PointData> getPoints() {
        return points;
    }

    public Shapes getShapeType() {
        return shapeType;
    }
}
