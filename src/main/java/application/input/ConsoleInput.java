package application.input;

public class ConsoleInput implements Input {
    private final static String WELCOME_TEXT = "Enter text: ";
    @Override
    public String getInput() {
        System.out.println(WELCOME_TEXT);
        return System.console().readLine();
    }
}
