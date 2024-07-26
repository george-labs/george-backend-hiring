package sk.george.intervierw.io.input;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import sk.george.intervierw.exception.NonRecoverableException;

public class ConsoleInputHandler implements InputHandler {
    private final Logger logger = Logger.getLogger(ConsoleInputHandler.class.getName());
    private final Scanner scanner;

    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public String loadSingle(String path) throws NonRecoverableException {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException ne) {
            logger.log(Level.WARNING, "User provide no input, returning null input");
            return null;
        } catch (IllegalStateException ise) {
            logger.log(Level.SEVERE, "Scanner is already closed", ise);
            throw new NonRecoverableException(ise);
        }
    }

    @Override
    public List<String> loadMultiple(String path) throws NonRecoverableException {
        // TODO: Implement implent looping scanning
        return List.of();
    }
}
