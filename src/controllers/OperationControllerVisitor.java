package controllers;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(CollocateController collocateController);

    void visit(ContinueController continueController);
}
