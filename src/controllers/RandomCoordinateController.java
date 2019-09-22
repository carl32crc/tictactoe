package controllers;

import models.Coordinate;

public interface RandomCoordinateController extends CoordinateController {

    Coordinate getTarget(Coordinate origin);

}