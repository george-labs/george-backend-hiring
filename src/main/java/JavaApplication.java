import service.Application;
import service.FileReader;
import service.TextInput;
import service.WordsCounter;

public class JavaApplication {

    public static void main(String[] args) {
        Application application = new Application(new TextInput(), new WordsCounter(), new FileReader());
        if (args.length > 0) {
            String fileName = args[0];
            application.run(fileName);
        }
        else {
            application.run();
        }

    }

}
