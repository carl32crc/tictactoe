package views.console;

import controllers.CoordinateController;
import controllers.RandomCoordinateController;
import controllers.UserCoordinateController;
import models.Coordinate;

class MoveTargetCoordinateView extends CollocateCoordinateView {

    private Coordinate origin;

    private Coordinate target;

    MoveTargetCoordinateView(CoordinateController coordinateController, Coordinate origin) {
        super(coordinateController);
        assert origin != null;
        this.origin = origin;
    }

    Coordinate getCoordinate() {
        this.getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        target = userCoordinateController.getTarget();
        new CoordinateView("A", target).read();
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        target = randomCoordinateController.getTarget(origin);
        this.show("pone en", target);
    }

}