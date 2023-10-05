package handler;

import io.Console;
import io.FileReader;

public class InputHandlerFactory {

    public static InputHandler create(String[] args) {
        if (args.length == 0 || args[0].equals("-index")) {
            return new ConsoleInputHandler(new Console(System.in));
        }

        return new FileInputHandler(new FileReader(" ", args[0]));
    }
}
