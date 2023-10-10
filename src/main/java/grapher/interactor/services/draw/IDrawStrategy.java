package grapher.interactor.services.draw;


import grapher.interactor.shapes.IShape;

public interface IDrawStrategy {
    void draw(IShape shape, ICanvas canvas);
}
