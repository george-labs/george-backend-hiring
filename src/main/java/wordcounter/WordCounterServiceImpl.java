package wordcounter;

import stopwords.StopWordsReader;

import java.util.Scanner;
import java.util.Set;

public class WordCounterServiceImpl implements WordCounterService {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS_TEMPLATE = "Number of words: %s";

    private final WordCounter wordCounter;
    private final StopWordsReader stopWordsReader;

    public WordCounterServiceImpl(final WordCounter wordCounter,
                                  final StopWordsReader stopWordsReader) {
        this.wordCounter = wordCounter;
        this.stopWordsReader = stopWordsReader;
    }

    @Override
    public void countWords() {
        //todo: it's either this or input from application argument text file
        final String userInput = readUserInputFromConsole();

        final Set<String> stopWords = stopWordsReader.getStopWordsList();

        final long wordCounts = wordCounter.countWords(userInput, stopWords);

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
