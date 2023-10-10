package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class EllipseCalc {

    public static List<PointData> getProperties(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        double lengthSideX = pointFinishData.x - pointStartData.x;
        double lengthSideY = pointFinishData.y - pointStartData.y;
        double radiusX = Math.abs(lengthSideX / 2);
        double radiusY = Math.abs(lengthSideY / 2);
        double x = pointStartData.x + lengthSideX / 2;
        double y = pointStartData.y + lengthSideY / 2;

        pointDataList.add(new PointData(x, y));
        pointDataList.add(new PointData(radiusX, radiusY));

        return pointDataList;
    }

}
