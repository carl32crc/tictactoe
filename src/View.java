import controllers.OperationController;
import controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    public void interact(OperationController operationController);
}
