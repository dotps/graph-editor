package grapher.interactor.services.ui;

import grapher.interactor.services.factory.IUIFactory;

public class UIService implements IUIService {

    private final IUIFactory uiFactory;

    public UIService(IUIFactory uiFactory) {
        this.uiFactory = uiFactory;
    }

    @Override
    public void createShapesMenu() {

    }
}
