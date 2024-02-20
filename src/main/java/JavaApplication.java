import java.util.*;

public class JavaApplication {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> stopWords = ReadFileAdapter.getStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);
        boolean printIndex = Arrays.asList(args).contains("-index");
        boolean readFromFile = Arrays.stream(args).anyMatch(it -> !it.startsWith("-"));
        String text;

        if (readFromFile) {
            String filename = getFilename(args);
            text = ReadFileAdapter.loadTextFromFile(filename);
        } else {
            System.out.print("Enter text: ");
            text = scanner.nextLine();
        }

        Counter counter = wordCounter.countWords(text);
        System.out.println(getOutputMessage(counter, printIndex));

    }

    private static String getFilename(String[] args) {
        Optional<String> filename = Arrays.stream(args).filter(it -> !it.startsWith("-")).findFirst();
        return filename.get();
    }

    private static String getOutputMessage(Counter counter, boolean printIndex) {
        String message = "Number of words: " + counter.getCount() + ", unique: " + counter.getCountUnique() +
                "; average word length: " + counter.getAverageLength() + " characters";

        if (printIndex) {
            String usedWords = String.join("\n", counter.getUsedWords());
            return message + "\nIndex:\n" + usedWords;
        }

        return message;
    }
}
