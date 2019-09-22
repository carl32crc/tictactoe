package views.console;

import controllers.ContinueController;
import utils.YesNoDialog;

class ContinueView {

    void interact(ContinueController continueController){
        continueController.resume(new YesNoDialog("Desea continuar")
                .read());
    }
}