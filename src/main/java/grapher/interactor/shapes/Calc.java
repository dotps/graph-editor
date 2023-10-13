package grapher.interactor.shapes;

public class Calc {
    public static int getMaxCountPointOnShape(int countPoint) {
        return countPoint > 360 ? 360 : countPoint;
    }
}
