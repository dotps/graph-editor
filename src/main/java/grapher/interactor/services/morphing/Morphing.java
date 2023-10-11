package grapher.interactor.services.morphing;

import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class Morphing {

    private final IDrawService drawService;

    public Morphing(IDrawService drawService) {
        this.drawService = drawService;
    }

    public void startMorph() {
        List<IShape> shapesOnCanvas = drawService.getShapesOnCanvas();
        List<IShape> shapesForMorphing = new ArrayList<>();
        shapesForMorphing.add(shapesOnCanvas.get(0));
        shapesForMorphing.add(shapesOnCanvas.get(1));
    }
}
