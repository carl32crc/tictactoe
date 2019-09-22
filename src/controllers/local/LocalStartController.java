package controllers.local;

import controllers.OperationControllerVisitor;
import controllers.StartController;
import models.Game;
import models.State;
import utils.ClosedInterval;

public class LocalStartController extends LocalOperationController implements
        StartController {

    private LocalCollocateControllerBuilder collocateControllerBuilder;

    LocalStartController(Game game,
                         LocalCollocateControllerBuilder collocateControllerBuilder) {
        super(game);
        assert collocateControllerBuilder != null;
        this.collocateControllerBuilder = collocateControllerBuilder;
    }

    public void start(int users) {
        assert new ClosedInterval(0, this.numPlayers()).includes(users);
        assert this.getState() == State.INITIAL;
        collocateControllerBuilder.build(users);
        this.setState(State.IN_GAME);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

}
