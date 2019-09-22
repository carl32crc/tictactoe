package controllers;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
