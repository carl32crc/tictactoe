package controllers.local;

import controllers.CoordinateControllerVisitor;
import controllers.UserCoordinateController;
import models.Coordinate;
import models.Game;

public class LocalUserCoordinateController extends LocalCoordinateController
        implements UserCoordinateController {

    protected LocalUserCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        return new Coordinate();
    }

    @Override
    public Coordinate getTarget() {
        return new Coordinate();
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }

}
