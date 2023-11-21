import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        try (InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt")) {
            countWords(args, System.in, stopWordInputStream, System.out);
        }
    }

    public static void countWords(String[] args, InputStream userInputStream, InputStream stopWordInputStream, OutputStream outputStream) throws IOException {
        String input = null;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        if (args.length == 1) {
            String path = args[0];
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
        WordCounter wordCounter = new WordCounter(WordCounter.SPACE_DELIMITER, WordCounter.ALPHABETIC_WORD_PATTERN, stopWordList);

        long wordCount = wordCounter.countWords(input);

        writer.write(String.format("Number of words: %d", wordCount));
        writer.flush();
    }
}