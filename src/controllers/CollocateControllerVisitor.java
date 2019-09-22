package controllers;

public interface CollocateControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
