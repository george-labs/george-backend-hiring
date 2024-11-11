import java.io.IOException;
import java.io.InputStream;
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

        System.out.println("Enter text: ");
        String textLine = scanner.nextLine();

        int numberOfWords = countNumberOfAlphabeticalWordsExcludingStopWords(textLine, stopWords);

        System.out.println("Number of words: " + numberOfWords);
    }

    public static int countNumberOfAlphabeticalWordsExcludingStopWords(String textLine, List<String> stopWords) {
        List<String> wordList = Arrays.asList(textLine.split(" "));
        wordList = wordList.stream()
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter(word -> !stopWords.contains(word))
                .toList();

        return wordList.size();
    }

    public static List<String> loadWordsFromResourceFile(String resourceFileName) throws IOException, NullPointerException {
        InputStream resourceInputStream =
                JavaApplication.class.getClassLoader().getResourceAsStream(resourceFileName);
        return Arrays.asList(new String(resourceInputStream.readAllBytes()).split("\\n"));
    }
}
