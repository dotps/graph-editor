package grapher.interactor.data;

import java.awt.*;
import java.io.Serializable;

public class PointData implements Serializable {
    private double x;
    private double y;

    public PointData(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
