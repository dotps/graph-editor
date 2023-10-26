package grapher.interactor.services.ui;

import grapher.interactor.services.IService;
import grapher.interactor.services.draw.ICanvas;

public interface IUIService extends IService {
    void showUI();
    void moveSlider(double position);
}
