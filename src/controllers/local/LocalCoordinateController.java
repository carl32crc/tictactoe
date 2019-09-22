package controllers.local;

import controllers.CoordinateController;
import models.Coordinate;
import models.Game;

public abstract class LocalCoordinateController extends LocalController
        implements CoordinateController {

    protected LocalCoordinateController(Game game) {
        super(game);
    }

    public abstract Coordinate getOrigin();

    public abstract Coordinate getTarget();

}
