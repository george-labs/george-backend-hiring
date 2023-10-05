package handler;

import io.ConsoleIO;
import io.FileReader;

public class HandlerFactory {

    public static Handler create(String[] args) {
        if (args.length == 0) {
            return new ConsoleHandler(new ConsoleIO(System.in));
        }

        return new FileHandler(new FileReader(" ", args[0]));
    }
}
