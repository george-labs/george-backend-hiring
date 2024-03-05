import bl.FileInputProvider;
import bl.InputProvider;
import bl.StdInputProvider;
import bl.WordCountApp;

public class JavaApplication {

    public static void main(String[] args) {
        InputProvider inputProvider = args.length == 0 ? new StdInputProvider() : new FileInputProvider(args[0]);
        WordCountApp app = new WordCountApp(inputProvider);
        app.run();
    }
}
