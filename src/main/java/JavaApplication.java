import logic.WordsCounter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static final String STOP_WORDS_FILE = "stopwords.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> stopWords;
        try {
            stopWords = loadWordsFromResourceFile(STOP_WORDS_FILE);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load " + STOP_WORDS_FILE, e);
        } catch (NullPointerException e) {
            throw new RuntimeException("Resource " + STOP_WORDS_FILE + "not found", e);
        }

        String textLine;
        if (args.length > 0) {
            textLine = getStringFromFile(args[0]);
        } else {
            System.out.println("Enter text: ");
            textLine = scanner.nextLine();
        }

        var textWordsCounter = new WordsCounter(textLine, stopWords);

        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters\n",
                textWordsCounter.getNumberOfWords(),
                textWordsCounter.getNumberOfUniqueWords(),
                textWordsCounter.getAverageWordLength());
    }

    public static String getStringFromFile(String fileName) {
        String textLine;

        try {
            textLine = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + fileName, e);
        }

        return textLine;
    }

    private static List<String> loadWordsFromResourceFile(String resourceFileName)
            throws IOException, NullPointerException {
        InputStream resourceInputStream =
                JavaApplication.class.getClassLoader().getResourceAsStream(resourceFileName);
        return Arrays.asList(new String(resourceInputStream.readAllBytes()).split("\n"));
    }

}
