import java.util.Scanner;

class WordCounterServiceImpl implements WordCounterService {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS_TEMPLATE = "Number of words: %s";

    private final WordCounter wordCounter;

    public WordCounterServiceImpl(final WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @Override
    public void countWords() {
        final String userInput = readUserInputFromConsole();

        final long wordCounts = wordCounter.countWords(userInput);

        printWordCountsToConsole(wordCounts);
    }

    private static void printWordCountsToConsole(final long wordCounts) {
        System.out.println(String.format(NUMBER_OF_WORDS_TEMPLATE, wordCounts));
    }

    private static String readUserInputFromConsole() {
        final Scanner inputScanner = new Scanner(System.in);

        System.out.print(ENTER_TEXT);

        final String userInput = inputScanner.nextLine();

        inputScanner.close();

        return userInput;
    }

}
