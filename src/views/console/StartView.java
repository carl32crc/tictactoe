package views.console;

import controllers.StartController;
import utils.LimitedIntDialog;

class StartView {

    void interact(StartController startController){
        int users = new LimitedIntDialog("Cuántos usuarios?", 0, 2).read();
        startController.start(users);
        new BoardView(startController).write();
    }
}