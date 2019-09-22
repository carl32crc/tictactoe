package controllers.local;

import controllers.CollocateControllerVisitor;
import controllers.Error;
import controllers.OperationControllerVisitor;
import controllers.PutController;
import models.Coordinate;
import models.Game;

public class LocalPutController extends LocalCollocateController implements
        PutController {

    LocalPutController(Game game, LocalCoordinateController coordinateController) {
        super(game, coordinateController);
    }

    @Override
    public void put(Coordinate target) {
        assert this.validateTarget(target) == null;
        super.put(target);
    }

    public Error validateTarget(Coordinate target) {
        return super.validateTarget(target);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void accept(CollocateControllerVisitor collocateControllerVisitor) {
        collocateControllerVisitor.visit(this);
    }
}
