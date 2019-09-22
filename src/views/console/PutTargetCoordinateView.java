package views.console;

import controllers.CoordinateController;
import controllers.RandomCoordinateController;
import controllers.UserCoordinateController;
import models.Coordinate;

class PutTargetCoordinateView extends CollocateCoordinateView {

    private Coordinate target;

    PutTargetCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    Coordinate getCoordinate(){
        target = this.getCoordinateController().getTarget();
        this.getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        new CoordinateView("En", target).read();
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("pone en", target);
    }

}
