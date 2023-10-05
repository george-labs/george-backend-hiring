package handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandlerFactoryTest {

    @Test
    public void createWithoutArgumentsMustReturnTheRightHandler() {
        String[] args = new String[0];
        Handler handler = HandlerFactory.create(args);

        Assertions.assertInstanceOf(ConsoleHandler.class, handler);
    }

    @Test
    public void createWithArgumentsMustReturnTheRightHandler() {
        String[] args = new String[1];
        args[0] = "mytext.txt";

        Handler handler = HandlerFactory.create(args);

        Assertions.assertInstanceOf(FileHandler.class, handler);
    }
}
