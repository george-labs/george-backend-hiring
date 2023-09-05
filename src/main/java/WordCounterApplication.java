import filereader.FileReaderService;
import filereader.FileReaderServiceImpl;
import stopwords.StopWordsReader;
import stopwords.StopWordsReaderConfiguration;
import stopwords.StopWordsReaderImpl;
import userinput.ConsoleUserInputReaderImpl;
import userinput.UserInputReader;
import wordcounter.WordCounter;
import wordcounter.WordCounterImpl;
import wordcounter.WordCounterService;
import wordcounter.WordCounterServiceImpl;

import java.util.Optional;

public class WordCounterApplication {

    private static final int STOP_WORDS_INDEX = 0;
    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        final StopWordsReader stopWordsReader = createStopWordsReader();

        final WordCounter wordCounter = new WordCounterImpl();

        final WordCounterService wordCounterService = new WordCounterServiceImpl(wordCounter, stopWordsReader);

        final String userInput = getUserInput();

        wordCounterService.countWords(userInput);
    }

    private static String getUserInput() {
        final UserInputReader consoleUserInputReader = new ConsoleUserInputReaderImpl();

        return consoleUserInputReader.getUserInput();
    }

    private static Optional<String> getWordFileName(final String[] applicationArguments) {
        if (applicationArguments.length == 0) {
            return Optional.empty();
        }

        try {
            final String wordsFileName = applicationArguments[STOP_WORDS_INDEX];

            return Optional.of(wordsFileName);
        } catch (ArrayIndexOutOfBoundsException e) {

            //todo: think about how to handle exception
            return Optional.empty();
        }
    }

    private static StopWordsReader createStopWordsReader() {
        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration(STOP_WORDS_FILE_NAME);

        final FileReaderService fileReaderService = new FileReaderServiceImpl();

        return new StopWordsReaderImpl(stopWordsReaderConfiguration, fileReaderService);
    }
}
