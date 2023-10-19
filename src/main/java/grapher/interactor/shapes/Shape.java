package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.IDrawStrategy;

import java.util.List;

public abstract class Shape implements IShape {

    private ShapeData data;

    private IDrawStrategy drawStrategy;

    @Override
    public IDrawStrategy getDrawStrategy() {
        return drawStrategy;
    }

    public void setDrawStrategy(IDrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public List<PointData> getAllPointsData() {
        return data.getPoints();
    }

    public PointData getFirstPointData() {
        return data.getPoints().get(0);
    }

    public void setData(ShapeData data) {
        this.data = data;
    }

    public ShapeData getData() {
        return data;
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {
        return null;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "data=" + data +
                '}';
    }

    public int normalizeCountPoint(int countPoint, double perimeter) {
        if (countPoint > perimeter)
            countPoint = (int) perimeter;
        return countPoint;
    }
}
