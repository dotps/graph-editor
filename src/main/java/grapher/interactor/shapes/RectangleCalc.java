package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class RectangleCalc {

    public static List<PointData> getVertexPoints(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        pointDataList.add(pointStartData);
        pointDataList.add(new PointData(pointFinishData.getX(), pointStartData.getY()));
        pointDataList.add(pointFinishData);
        pointDataList.add(new PointData(pointStartData.getX(), pointFinishData.getY()));

        return pointDataList;
    }

    public static int getPerimeter(List<PointData> pointDataList) {

        double x1 = pointDataList.get(0).getX();
        double y1 = pointDataList.get(0).getY();
        double x2 = pointDataList.get(1).getX();
        double y2 = pointDataList.get(1).getY();
        double x3 = pointDataList.get(2).getX();
        double y3 = pointDataList.get(2).getY();

        double lengthSideX = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double lengthSideY = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        
        int perimeter = (int) Math.floor((lengthSideX + lengthSideY) * 2);

        return perimeter;
    }
}
