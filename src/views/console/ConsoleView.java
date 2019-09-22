package views.console;

import controllers.ContinueController;
import main.View;

import controllers.CollocateController;
import controllers.OperationController;
import controllers.StartController;


public class ConsoleView implements View {

    private StartView startView;

    private GameView gameView;

    private ContinueView continueView;

    public ConsoleView(){
        startView = new StartView();
        gameView = new GameView();
        continueView = new ContinueView();
    }

    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(CollocateController collocateController) {
        gameView.interact(collocateController);
    }

    @Override
    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }

}