import controllers.OperationController;
import controllers.local.LocalLogic;
import views.console.ConsoleView;

public class TicTacToe {

    private Logic logic;

    private View view;

    public TicTacToe(Logic logic, View view) {
        this.logic = logic;
        this.view = view;
    }

    public void play() {
        OperationController controller;
        do {
           controller = logic.getOperationController();
           if(controller != null) {
               view.interact(controller);
           }
        } while(controller != null);
    }

    public static void main(String[] args) {
        new TicTacToe(new LocalLogic(), new ConsoleView()).play();
    }
}
