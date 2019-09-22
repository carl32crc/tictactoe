package views.console;

import controllers.CollocateController;
import controllers.CollocateControllerVisitor;
import controllers.MoveController;
import controllers.PutController;
import controllers.Error;
import models.Color;
import models.Coordinate;
import utils.IO;

class GameView implements CollocateControllerVisitor {

    private IO io = new IO();

    private ColorView colorView;

    private Coordinate origin;

    public void interact(CollocateController collocateController) {
        colorView = new ColorView(collocateController.take());
        collocateController.accept(this);
    }

    @Override
    public void visit(PutController putController) {
        this.showTitle("Pone", putController.take());
        PutTargetCoordinateView putCoordinateView = new PutTargetCoordinateView(
                putController.getCoordinateController());
        this.put(putController, putCoordinateView);
        this.showGame(putController);
    }

    @Override
    public void visit(MoveController moveController) {
        this.showTitle("Mueve", moveController.take());
        MoveOriginCoordinateView moveOriginCoordinateView = new MoveOriginCoordinateView(
                moveController.getCoordinateController());
        this.remove(moveController, moveOriginCoordinateView);
        MoveTargetCoordinateView moveTargetCoordinateView = new MoveTargetCoordinateView(
                moveController.getCoordinateController(), origin);
        this.put(moveController, moveTargetCoordinateView);
        this.showGame(moveController);
    }

    private void showTitle(String title, Color color) {
        colorView.writeln(title + " el jugador ");
    }

    private void put(PutController putController,
                     CollocateCoordinateView collocateCoordinateView) {
        Coordinate target;
        Error error = null;
        do {
            target = collocateCoordinateView.getCoordinate();
            error = putController.validateTarget(target);
            if (error != null) {
                io.writeln("" + error);
            }
        } while (error != null);
        putController.put(target);
    }

    private void remove(MoveController moveController,
                        CollocateCoordinateView collocateCoordinateView) {
        Error error = null;
        do {
            origin = collocateCoordinateView.getCoordinate();
            error = moveController.validateOrigin(origin);
            if (error != null) {
                io.writeln("" + error);
            }
        } while (error != null);
        moveController.remove(origin);
    }

    private void put(MoveController moveController,
                     CollocateCoordinateView collocateCoordinateView) {
        Coordinate target;
        Error error = null;
        do {
            target = collocateCoordinateView.getCoordinate();
            error = moveController.validateTarget(origin, target);
            if (error != null) {
                io.writeln("" + error);
            }
        } while (error != null);
        moveController.put(target);
    }

    private void showGame(CollocateController collocateController) {
        new BoardView(collocateController).write();
        if (collocateController.existTicTacToe()) {
            colorView.writeWinner();
        }
    }

}
