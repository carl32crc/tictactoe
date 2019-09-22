package controllers;

import models.Coordinate;

public interface MoveController extends CollocateController {

    Error validateOrigin(Coordinate origin);

    void remove(Coordinate origin);

    Error validateTarget(Coordinate origin, Coordinate target);

}