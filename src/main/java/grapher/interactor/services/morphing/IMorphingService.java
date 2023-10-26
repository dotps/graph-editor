package grapher.interactor.services.morphing;

import grapher.interactor.services.IService;
import grapher.interactor.services.draw.ICanvas;

public interface IMorphingService extends IService {
    void init(double position, ICanvas canvas);

}
