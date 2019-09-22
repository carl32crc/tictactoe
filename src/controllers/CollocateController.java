package controllers;

import models.Color;
import models.Coordinate;

public interface CollocateController extends OperationController,
        PresenterController {

    Color take();

    void put(Coordinate target);

    boolean existTicTacToe();

    CoordinateController getCoordinateController();

    Error validateTarget(Coordinate target);

    void accept(CollocateControllerVisitor collocateControllerVisitor);

}