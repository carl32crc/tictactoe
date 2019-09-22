package views.console;

import controllers.CoordinateController;
import controllers.RandomCoordinateController;
import controllers.UserCoordinateController;
import models.Coordinate;

class MoveOriginCoordinateView extends CollocateCoordinateView {

    private Coordinate origin;

    MoveOriginCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    Coordinate getCoordinate() {
        origin = this.getCoordinateController().getOrigin();
        this.getCoordinateController().accept(this);
        return origin;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        new CoordinateView("De", origin).read();
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("quita de", origin);
    }

}
