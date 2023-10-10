package grapher.interactor.shapes;

import grapher.interactor.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class RectangleCalc {

    public static List<PointData> getVertexPoints(PointData pointStartData, PointData pointFinishData) {

        List<PointData> pointDataList = new ArrayList<>();

        pointDataList.add(pointStartData);
        pointDataList.add(new PointData(pointFinishData.x, pointStartData.y));
        pointDataList.add(pointFinishData);
        pointDataList.add(new PointData(pointStartData.x, pointFinishData.y));

        return pointDataList;
    }
}
