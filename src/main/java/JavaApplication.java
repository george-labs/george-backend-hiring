import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        try (InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt")) {
            countWords(CLIParser.parse(args), System.in, stopWordInputStream, System.out);
        }
    }

    public static void countWords(CLIParser.CLIParserResult args, InputStream userInputStream, InputStream stopWordInputStream, OutputStream outputStream) throws IOException {
        String input = null;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        if (args.getArguments().size() == 1) {
            String path = args.getArguments().get(0);
            input = Files.readString(Path.of(path));
        } else {
            writer.write("Enter text: ");
            writer.flush();

            Scanner sc = new Scanner(userInputStream);

            if (sc.hasNextLine()) {
                input = sc.nextLine();
            }
        }

        StopWordList stopWordList = StopWordList.of(stopWordInputStream);
        WordCounter wordCounter = new WordCounter(new Tokenizer(), stopWordList);

        Statistics statistics = wordCounter.countWords(input);

        writer.write(String.format(Locale.US, "Number of words: %d, unique: %d; average word length: %.2f characters", statistics.getWordCount(), statistics.getUniqueWordCount(), statistics.getAverageWordLength()));

        if (args.isOptionActive("index")) {
            writer.write("\nIndex:\n");

            for (String token : statistics.getIndex()) {
                writer.write(String.format("%s\n", token));
            }
        }

        writer.flush();
    }
}