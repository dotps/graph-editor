package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.List;

public class Star extends Shape {
    public Star(Point pointStartArea, Point pointFinishArea) {

        List<Point> points = StarCalc.getStarVertexPoints(pointStartArea, pointFinishArea);

//        setData(new StarData(points));
//        setDrawStrategy(new DrawStar());
    }

    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {
        return null;
    }

}
