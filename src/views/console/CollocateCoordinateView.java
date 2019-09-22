package views.console;

import controllers.CoordinateController;
import controllers.CoordinateControllerVisitor;
import models.Coordinate;
import utils.IO;

abstract class CollocateCoordinateView implements CoordinateControllerVisitor {

    private CoordinateController coordinateController;

    private IO io;

    protected CollocateCoordinateView(CoordinateController coordinateController){
        assert coordinateController != null;
        this.coordinateController = coordinateController;
        io = new IO();
    }

    abstract Coordinate getCoordinate();

    protected void show(String infix, Coordinate coordinate){
        new CoordinateView("La máquina " + infix + " ", coordinate).write();
        io.readString(". Pulse enter para continuar");
    }

    protected CoordinateController getCoordinateController(){
        return coordinateController;
    }
}
