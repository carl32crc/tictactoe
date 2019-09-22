package controllers.local;

import controllers.CollocateController;
import controllers.CoordinateController;
import controllers.Error;
import models.Coordinate;
import models.Game;

abstract class LocalCollocateController extends LocalOperationController
        implements CollocateController {

    private LocalCoordinateController coordinateController;

    protected LocalCollocateController(Game game,
                                      LocalCoordinateController coordinateController) {
        super(game);
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    public Error validateTarget(Coordinate target) {
        if (!this.empty(target)) {
            System.out.println("Error no libre");
            return Error.NOT_EMPTY;
        }
        return null;
    }

    public CoordinateController getCoordinateController() {
        return coordinateController;
    }

}
