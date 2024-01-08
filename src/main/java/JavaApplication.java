import java.io.IOException;
import java.util.List;

public class JavaApplication {

    private static TextReader createReader(String[] args) {
        String filename = null;
        if (args.length > 0) {
            filename = args[0].trim();
        }
        TextReader reader;
        if (filename != null && !filename.isEmpty()) {
            reader = new FileTextReader(filename);
        } else {
            reader = new SystemTextReader();
        }
        return reader;
    }

    public static WordCounter createWordCounter(TextReader reader) throws IOException {
        List<String> lines = reader.read();
        return WordCounterFactory.createWithDefaultStopWords(lines);
    }

    public static void main(String[] args) throws IOException {
        TextReader reader = createReader(args);
        WordCounter wordCounter = createWordCounter(reader);
        System.out.println("Number of words: " + wordCounter.count() + ", unique: " + wordCounter.unique());

    }
}
