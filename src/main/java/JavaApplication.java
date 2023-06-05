import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    private final static String FILENAME_STOP_WORDS = "stopWords.txt";

    public static void main(String[] args) {
        StopWordsReader stopWordsReader = new StopWordsReader();
        List<String> stopWordList = stopWordsReader.getWordsFromResources(FILENAME_STOP_WORDS);

        String input;

        if (args.length > 0 && args[0].endsWith(".txt")) {
            input = getInputFromFile(stopWordsReader, args[0]);
        } else {
            input = getInputFromUser();
        }

        WordCounter wordCounter = new WordCounter();
        WordCountInfo wordCountInfo = wordCounter.getCountOfWords(input, stopWordList);
        System.out.println("Number of words: " + wordCountInfo.getCountOfAllWords() +
                ", unique: " + wordCountInfo.getCountOfUniqueWords());

    }

    private static String getInputFromUser() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String getInputFromFile(StopWordsReader stopWordsReader, String fileName) {
        try {
            List<String> wordListFromResources = stopWordsReader.getWordsFromResources(fileName);
            return wordListFromResources.stream()
                    .reduce((result, s) -> result + " " + s).get();
        } catch (IllegalArgumentException e) {
            return getInputFromUser();
        }
    }
}
