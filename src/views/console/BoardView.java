package views.console;

import controllers.PresenterController;
import models.Coordinate;
import utils.IO;

class BoardView {

    private PresenterController controller;

    BoardView(PresenterController controller) {
        assert controller != null;
        this.controller = controller;
    }

    void write() {
        IO io = new IO();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView(controller.getColor(new Coordinate(i, j)))
                        .write(" ");
            }
            io.writeln();
        }
    }
}