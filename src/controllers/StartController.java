package controllers;

public interface StartController extends OperationController,
        PresenterController {

    void start(int users);

}
