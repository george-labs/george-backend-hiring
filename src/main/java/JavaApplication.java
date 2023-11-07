import java.io.IOException;


public class JavaApplication {
    public static void main(String[] args) throws IOException {
        WordEngine wordEngine = new WordEngine();
        if (args.length > 0)
            wordEngine.execute(args[0]);
        else
            wordEngine.execute("");
    }

}
