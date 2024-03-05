import bl.WordCountApp;

public class JavaApplication {

    public static void main(String[] args) {
        WordCountApp app = new WordCountApp();
        app.run(args.length == 0 ? null : args[0]);
    }
}
