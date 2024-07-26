package sk.george.intervierw.io.input;

import java.util.List;

import sk.george.intervierw.exception.NonRecoverableException;

/**
 * The interface for handling inputs
 */
public interface InputHandler {
    /**
     * Loads the input data from the specified path if available
     * @param path The path to the input or ignored if there is no need for path
     * @return a list of loaded strings
     * @throws NonRecoverableException if an error occurs during the input loading process,
     */
    String loadSingle(String path) throws NonRecoverableException;

    List<String> loadMultiple(String path) throws NonRecoverableException;
}
