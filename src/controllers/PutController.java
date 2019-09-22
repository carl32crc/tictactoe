package controllers;

import models.Coordinate;

public interface PutController extends CollocateController {

    Error validateTarget(Coordinate target);

}
