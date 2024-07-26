package sk.george.intervierw.io.output;

/**
 * Output handler using the system's standard output
 */
public class SystemOutputHandler implements OutputHandler {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
