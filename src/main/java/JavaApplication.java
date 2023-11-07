import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        WordEngine wordEngine = new WordEngine();
        if (args.length > 0)
            wordEngine.execute(args[0]);
        else
            wordEngine.execute("nofile");
    }

}
