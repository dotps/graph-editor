package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.strategies.DrawLine;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {
    public Rectangle(Point pointStart, Point pointFinish) {

        List<PointData> pointDataList = RectangleCalc.getVertexPoints(pointStart.getFirstPointData(), pointFinish.getFirstPointData());

        setData(new ShapeData(pointDataList, Shapes.Rectangle));
        injectDrawStrategy();

    }

    public Rectangle() {
        injectDrawStrategy();
    }

    private void injectDrawStrategy() {
        setDrawStrategy(new DrawLine(true));
    }

    /*
    @Override
    public List<PointData> getPointsDataForMorph(int countPoint) {

        List<PointData> pointsData = getAllPointsData();

        int diffCount = countPoint - pointsData.size();
        debug.log("diffCount " + diffCount);

        for (PointData pointData : pointsData) {
            debug.log(pointData.getX() + " " + pointData.getY());
        }
        debug.log("===");

        while (diffCount > 0) {
            debug.log(diffCount);
            PointData pointData1 = pointsData.get(diffCount);
            PointData pointData2 = pointsData.get(diffCount+1);

            double x = pointData1.getX() - (pointData1.getX() - pointData2.getX()) / 2;
            double y = pointData1.getY() - (pointData1.getY() - pointData2.getY()) / 2;

            debug.log(pointData1.getX() + " " + pointData1.getY());
            debug.log(pointData2.getX() + " " + pointData2.getY());
            debug.log(x + " insert " + diffCount+1 + " << " + y);
            debug.log("---");

            pointsData.add(diffCount + 1, new PointData(x, y));

            diffCount--;
        }

        debug.log("*****");
        for (PointData pointData : pointsData) {
            debug.log(pointData.getX() + " " + pointData.getY());
        }

        return pointsData;


        return null;
    }
*/
    public List<PointData> getPointsDataForMorph(int countPoint) {

        List<PointData> points = new ArrayList<>();

        int perimeter = getPerimeter();
        double distance = perimeter / countPoint;

        debug.log("countPoint " + countPoint);
        debug.log("perimeter " + perimeter);
        debug.log("distance " + distance);

        List<PointData> pointsData = getData().getPoints();

        for (int i = 0; i < pointsData.size(); i++) {

            double x1 = pointsData.get(i).getX();
            double y1 = pointsData.get(i).getY();

            debug.log(x1 + "<<< = >>>" + y1);

            double x2, y2;

            if (i+1 <= pointsData.size()-1) {
                x2 = pointsData.get(i + 1).getX();
                y2 = pointsData.get(i + 1).getY();
            }
            else {
                x2 = pointsData.get(0).getX();
                y2 = pointsData.get(0).getY();
            }

            debug.log(x2 + "<<< + >>>" + y2);

            double xx = x1;
            double yy = y1;

//            points.add(new PointData(xx,yy));

            if (x1 - x2 < 0) {
                while (xx < x2) {
                    xx += distance;
                    if (xx >= x2)
                        break;
                    if (Math.abs(xx - x2) < distance / 2)
                        break;
                    PointData point = new PointData(xx, yy);
                    points.add(point);
                    debug.log(points.size() + ")" + point.getX() + "=" + point.getY());
                }
            }

            if (y1 - y2 < 0) {
                while (yy < y2) {
                    yy += distance;
                    if (yy >= y2)
                        break;
                    PointData point = new PointData(xx, yy);
                    points.add(point);
                    debug.log(points.size() + ")" + point.getX() + "=" + point.getY());
                }
            }
            if (x1 - x2 >= 0) {
                while (xx > x2) {
                    xx -= distance;
                    if (xx <= x2)
                        break;
                    PointData point = new PointData(xx, yy);
                    points.add(point);
                    debug.log(points.size() + ")" + point.getX() + "=" + point.getY());
                }
            }
            if (y1 - y2 >= 0) {
                while (yy > y2) {
                    yy -= distance;
                    if (yy <= y2)
                        break;
                    PointData point = new PointData(xx, yy);
                    points.add(point);
                    debug.log(points.size() + ")" + point.getX() + "=" + point.getY());
                }
            }
        }

        debug.log("points" + points.size());

        return points;
    }

    @Override
    public int getPerimeter() {
        return RectangleCalc.getPerimeter(getData().getPoints());
    }
}
