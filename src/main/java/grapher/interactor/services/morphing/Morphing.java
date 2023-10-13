package grapher.interactor.services.morphing;

import grapher.interactor.data.PointData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Point;
import grapher.utils.debug;

import java.util.List;

public class Morphing {

    private final IDrawService drawService;
    private final ICanvas canvas;
    private IShape startShape;
    private IShape finishShape;
    private int countPointForMorphing = 6;

    public Morphing(IDrawService drawService, ICanvas canvas) {
        this.drawService = drawService;
        this.canvas = canvas;
        init();
    }

    private void init() {

        List<IShape> shapesOnCanvas = drawService.getShapesOnCanvas();

        if (shapesOnCanvas.size() < 2)
            return;

        startShape = shapesOnCanvas.get(0);
        finishShape = shapesOnCanvas.get(1);

        int countStartShapePoints = startShape.getAllPointsData().size();
        int countFinishShapePoints = finishShape.getAllPointsData().size();

        int maxCountShapePoints = (countStartShapePoints >= countFinishShapePoints) ? countStartShapePoints : countFinishShapePoints;

        int startShapePerimeter = startShape.getPerimeter();
        int finishShapePerimeter = finishShape.getPerimeter();
        debug.log(startShapePerimeter);
        debug.log(finishShapePerimeter);

        int minCountShapePoints = (startShapePerimeter <= finishShapePerimeter) ? startShapePerimeter : finishShapePerimeter;
        debug.log("minCountShapePoints " + minCountShapePoints);

        List<PointData> pointsStartShape = startShape.getPointsDataForMorph(minCountShapePoints);
        List<PointData> pointsFinishShape = finishShape.getPointsDataForMorph(minCountShapePoints);

//        drawLogMorphPoint(pointsStartShape);
        drawLogMorphPoint(pointsFinishShape);

//        startMorph(pointsStartShape, pointsFinishShape);
    }

    private void drawLogMorphPoint(List<PointData> points) {
        int i = 1;
        for (PointData pointData : points) {
            Point point = new Point(pointData.getX(), pointData.getY());
            drawService.draw(point, canvas);
            drawService.drawText(Integer.toString(i), point, canvas);
            i++;
        }
    }

    public void startMorph(List<PointData> pointsStartShape, List<PointData> pointsFinishShape) {

        for (int i = 0; i < pointsStartShape.size(); i++) {

            PointData pointStartData = pointsStartShape.get(i);
            PointData pointFinishData = pointsFinishShape.get(i);
            PointData length = Point.diffData(pointStartData, pointFinishData);

            debug.log("X " + length.getX() + ", Y " + length.getY());

            PointData morphPointData = new PointData(pointStartData.getX() + length.getX() / 2, pointStartData.getY() + length.getY() / 2);
            Point morphPoint = new Point(morphPointData.getX(), morphPointData.getY());

            drawService.draw(morphPoint, canvas);
            drawService.drawText(Integer.toString(i + 1), morphPoint, canvas);
        }
    }
}
