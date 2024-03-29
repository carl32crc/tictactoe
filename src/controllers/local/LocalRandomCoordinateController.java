package controllers.local;

import controllers.CoordinateControllerVisitor;
import controllers.RandomCoordinateController;
import models.Coordinate;
import models.Game;

public class LocalRandomCoordinateController extends LocalCoordinateController
        implements RandomCoordinateController{

    protected LocalRandomCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        Coordinate origin = new Coordinate();
        boolean ok;
        do {
            origin.random();
            ok = this.full(origin);
        } while (!ok);
        Coordinate result = origin;
        origin = null;
        return result;
    }

    @Override
    public Coordinate getTarget() {
        Coordinate target = new Coordinate();
        boolean ok;
        do {
            target.random();
            ok = this.empty(target);
        } while (!ok);
        Coordinate result = target;
        target = null;
        return result;
    }

    public Coordinate getTarget(Coordinate origin) {
        assert origin != null;
        boolean ok;
        Coordinate target;
        do {
            target = this.getTarget();
            ok = !origin.equals(target);
        } while(!ok);
        return target;
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }

}
