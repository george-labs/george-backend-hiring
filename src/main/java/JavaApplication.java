import service.Application;
import service.TextInput;
import service.WordsCounter;

public class JavaApplication {

    public static void main(String[] args) {

        Application application = new Application(new TextInput(), new WordsCounter());
        application.run();
    }

}
