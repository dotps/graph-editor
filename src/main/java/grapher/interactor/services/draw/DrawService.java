package grapher.interactor.services.draw;

import grapher.interactor.shapes.IShape;

public class DrawService implements IDrawService {

    public void draw(IShape shape, ICanvas canvas) {
        IDrawStrategy drawStrategy = shape.getDrawStrategy();
        drawStrategy.draw(shape, canvas);
    }

}
