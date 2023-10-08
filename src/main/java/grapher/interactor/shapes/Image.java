package grapher.interactor.shapes;

import grapher.interactor.services.draw.strategies.DrawLine;

import java.util.ArrayList;
import java.util.List;

public class Image extends Shape {

    List<IShape> shapes = new ArrayList<>();

    public Image(List<IShape> shapes) {
        this.shapes = shapes;

//        data = new ImageData(interactor.shapes);
        //setDrawStrategy(new DrawLine());
    }
}
