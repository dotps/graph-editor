package grapher.interactor.services.draw;

import grapher.interactor.shapes.IShape;

public class DrawService implements IDrawService {

    public void draw(IShape shape) {
        IDrawStrategy drawStrategy = shape.getDrawStrategy();
        drawStrategy.draw(shape);
    }

}
