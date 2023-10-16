package grapher.interactor.services.morphing;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.shapes.*;
import grapher.utils.debug;

import java.util.ArrayList;
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
    }

    public void init(double position) {

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

        int minCountShapePoints = (startShapePerimeter <= finishShapePerimeter) ? startShapePerimeter : finishShapePerimeter;
        debug.log("minCountShapePoints " + minCountShapePoints);

        minCountShapePoints = 30;

        List<PointData> pointsStartShape = startShape.getPointsDataForMorph(minCountShapePoints);
        List<PointData> pointsFinishShape = finishShape.getPointsDataForMorph(minCountShapePoints);

        drawLogMorphPoint(pointsStartShape);
        drawLogMorphPoint(pointsFinishShape);

        startMorph(pointsStartShape, pointsFinishShape, position);
    }

    private void drawLogMorphPoint(List<PointData> points) {
        int i = 1;
        for (PointData pointData : points) {
            Point point = new Point(pointData.getX(), pointData.getY());
            drawService.draw(point, canvas);
//            drawService.drawText(Integer.toString(i), point, canvas);
            i++;
        }
    }

    public void startMorph(List<PointData> pointsStartShape, List<PointData> pointsFinishShape, double position) {

        List<PointData> pointDataList = new ArrayList<>();
        for (int i = 0; i < pointsStartShape.size(); i++) {

            PointData pointStartData = pointsStartShape.get(i);
            PointData pointFinishData = pointsFinishShape.get(i);
            PointData length = Point.diffData(pointStartData, pointFinishData);

            PointData morphPointData = new PointData(pointStartData.getX() + length.getX() * position, pointStartData.getY() + length.getY() * position);
            pointDataList.add(morphPointData);
        }

        Polygon polygon = new Polygon();
        polygon.setData(new ShapeData(pointDataList, Shapes.Polygon));

        drawService.draw(polygon, canvas);
    }
}
