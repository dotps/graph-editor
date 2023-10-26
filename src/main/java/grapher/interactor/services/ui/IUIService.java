package grapher.interactor.services.ui;

import grapher.interactor.services.IService;

public interface IUIService extends IService {
    void createUI();
    void moveSlider(double position);
}
