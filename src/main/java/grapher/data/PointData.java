package grapher.data;

import java.io.Serializable;

public class PointData implements Serializable {
    public double x;
    public double y;

    public PointData(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
