package grapher.interactor.shapes;

import grapher.interactor.data.PointData;
import grapher.utils.debug;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int getMaxCountPointOnShape(int countPoint) {
        return countPoint > 360 ? 360 : countPoint;
    }


}
