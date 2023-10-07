package grapher.interactor.services.draw;

import grapher.interactor.services.IService;
import grapher.interactor.shapes.IShape;

public interface IDrawService extends IService {
    void draw(IShape shape);
}
