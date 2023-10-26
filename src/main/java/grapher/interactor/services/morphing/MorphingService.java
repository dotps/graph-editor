package grapher.interactor.services.morphing;

import grapher.interactor.data.PointData;
import grapher.interactor.data.ShapeData;
import grapher.interactor.services.draw.ICanvas;
import grapher.interactor.services.draw.IDrawService;
import grapher.interactor.services.ui.IUIFactory;
import grapher.interactor.shapes.IShape;
import grapher.interactor.shapes.Point;
import grapher.interactor.shapes.Polygon;
import grapher.interactor.shapes.Shapes;

import java.util.ArrayList;
import java.util.List;

public class MorphingService implements IMorphingService {

    private final IDrawService drawService;
    private ICanvas canvas;

    public MorphingService(IDrawService drawService) {
        this.drawService = drawService;
    }

    public void init(double position, ICanvas canvas) {

        this.canvas = canvas;

        List<IShape> shapesOnCanvas = drawService.getShapesOnCanvas();

        int minShapesForMorphing = 2;
        if (shapesOnCanvas.size() < minShapesForMorphing)
            return;

        int indexStartShape = 0;
        int indexFinishShape = 1;
        IShape startShape = shapesOnCanvas.get(indexStartShape);
        IShape finishShape = shapesOnCanvas.get(indexFinishShape);

//        int countStartShapePoints = startShape.getAllPointsData().size();
//        int countFinishShapePoints = finishShape.getAllPointsData().size();
//        int maxCountShapePoints = (countStartShapePoints >= countFinishShapePoints) ? countStartShapePoints : countFinishShapePoints;
//        int startShapePerimeter = startShape.getPerimeter();
//        int finishShapePerimeter = finishShape.getPerimeter();
//        int minCountShapePoints = (startShapePerimeter <= finishShapePerimeter) ? startShapePerimeter : finishShapePerimeter;
//        debug.log("minCountShapePoints " + minCountShapePoints);

        int minCountShapePoints = 30;

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
            drawService.drawText(Integer.toString(i), point, canvas);
            i++;
        }
    }

    private void startMorph(List<PointData> pointsStartShape, List<PointData> pointsFinishShape, double position) {

        List<PointData> pointDataList = new ArrayList<>();
        for (int i = 0; i < pointsStartShape.size(); i++) {

            PointData pointStartData = pointsStartShape.get(i);
            PointData pointFinishData = pointsFinishShape.get(i);
            PointData length = Point.diffData(pointStartData, pointFinishData);

            PointData morphPointData = new PointData(pointStartData.getX() - length.getX() * position, pointStartData.getY() - length.getY() * position);
            pointDataList.add(morphPointData);
            drawService.drawText(Integer.toString(i + 1), new Point(morphPointData.getX(), morphPointData.getY()), canvas);
        }

        Polygon polygon = new Polygon();
        polygon.setData(new ShapeData(pointDataList, Shapes.Polygon));

        drawService.draw(polygon, canvas);

    }
}
