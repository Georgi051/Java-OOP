import core.EngineControllerImpl;
import core.interfaces.EngineController;


public class Main {
    public static void main(String[] args) {
        EngineController engineController = new EngineControllerImpl();
        engineController.run();
    }
}
