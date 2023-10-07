package grapher.interactor.shapes;

import java.util.ArrayList;
import java.util.List;

public class StarCalc {

    private static final int[] ANGLES_STAR_VERTEX = { 18, 90, 162, 234, 306 };

    public static List<Point> getStarVertexPoints(Point pointStartRange, Point pointFinishRange) {

        double radius = getRadiusCircleFromArea(pointStartRange, pointFinishRange);
        List<Point> points = new ArrayList<>();

        for (int angle : ANGLES_STAR_VERTEX) {
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            points.add(new Point(x, y));
        }

        return points;
    }

    private static double getRadiusCircleFromArea(Point pointStartRange, Point pointFinishRange) {
        return 10;
    }
}
