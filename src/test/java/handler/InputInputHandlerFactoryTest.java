package handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInputHandlerFactoryTest {

    @Test
    public void createWithoutArgumentsMustReturnTheRightHandler() {
        String[] args = new String[0];
        InputHandler inputHandler = InputHandlerFactory.create(args);

        Assertions.assertInstanceOf(ConsoleInputHandler.class, inputHandler);
    }

    @Test
    public void createWithArgumentsMustReturnTheRightHandler() {
        String[] args = new String[1];
        args[0] = "mytext.txt";

        InputHandler inputHandler = InputHandlerFactory.create(args);

        Assertions.assertInstanceOf(FileInputHandler.class, inputHandler);
    }
}
