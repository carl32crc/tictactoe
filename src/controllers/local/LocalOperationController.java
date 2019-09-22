package controllers.local;

import controllers.OperationController;
import controllers.OperationControllerVisitor;
import models.Game;

public abstract class LocalOperationController extends LocalController
        implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(
            OperationControllerVisitor operationControllerVisitor);

}
