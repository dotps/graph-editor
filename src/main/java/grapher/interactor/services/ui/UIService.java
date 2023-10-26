package grapher.interactor.services.ui;

public class UIService implements IUIService {
    private final IUIFactory uiFactory;
    
    public UIService(IUIFactory uiFactory) {
        this.uiFactory = uiFactory;
    }

    @Override
    public void showUI() {
        uiFactory.createUI();
    }

    @Override
    public void moveSlider(double position) {
        uiFactory.setSliderPosition(position);
    }
}
