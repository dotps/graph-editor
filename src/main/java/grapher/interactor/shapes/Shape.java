package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.IDrawStrategy;

import java.util.List;

public abstract class Shape implements IShape {

    public static final int MIN_COUNT_POINTS_FOR_SHAPE = 2;
    public static final int INDEX_START_POINT = 0;
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
        return data.getPoints().get(INDEX_START_POINT);
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

    public void setPointsDirection() {
        List<PointData> points = data.getPoints();
        if (points.size() < MIN_COUNT_POINTS_FOR_SHAPE)
            return;

        PointData startPoint = points.get(INDEX_START_POINT);
        PointData finishPoint = points.get(INDEX_START_POINT + 1);

        // TODO: перевернуть массив ??
        // Как определить направление ??
//        if (isLeftBottomDirection()
//             ||
//            startPoint.getX() < finishPoint.getX() && startPoint.getY() < finishPoint.getY()
//        )

    }

    private boolean isLeftBottomDirection(PointData startPoint, PointData finishPoint) {
        return startPoint.getX() > finishPoint.getX() && startPoint.getY() < finishPoint.getY();
    }

    private boolean isRightBottomDirection(PointData startPoint, PointData finishPoint) {
        return startPoint.getX() > finishPoint.getX() && startPoint.getY() < finishPoint.getY();
    }
}
