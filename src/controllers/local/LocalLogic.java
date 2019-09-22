package controllers.local;


import main.Logic;
import models.Game;

public class LocalLogic implements Logic {

    private Game game;

    private LocalCollocateControllerBuilder collocateControllerBuilder;

    private LocalStartController startController;

    private LocalContinueController continueController;

    public LocalLogic() {
        game = new Game();
        collocateControllerBuilder = new LocalCollocateControllerBuilder(game);
        startController = new LocalStartController(game, collocateControllerBuilder);
        continueController = new LocalContinueController(game);
    }

    public LocalOperationController getOperationController() {
        switch (game.getState()){
            case INITIAL:
                return startController;
            case IN_GAME:
                return collocateControllerBuilder.getCollocateController();
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
