import service.*;

public class JavaApplication {

    public static void main(String[] args) {
        UserInput userInput = new TextInput();
        if (args.length > 0) {
            String fileName = args[0];
            userInput = new FileInput(fileName);
        }
        Application application = new Application(userInput, new WordsCounter(), new FileReader());
        application.run();

    }

}
