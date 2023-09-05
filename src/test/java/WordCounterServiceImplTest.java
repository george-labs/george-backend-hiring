import filereader.FileReaderService;
import filereader.FileReaderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stopwords.StopWordsReader;
import stopwords.StopWordsReaderConfiguration;
import stopwords.StopWordsReaderImpl;
import wordcounter.WordCounter;
import wordcounter.WordCounterImpl;
import wordcounter.WordCounterService;
import wordcounter.WordCounterServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterServiceImplTest {

    private static final String EXPECTED_RESULT_TEMPLATE = "Number of words: %s\n";

    private WordCounterService wordCounterService;

    @BeforeEach
    void setup() {
        final WordCounter wordCounter = new WordCounterImpl();

        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration("stopwords.txt");

        final FileReaderService fileReaderService = new FileReaderServiceImpl();

        final StopWordsReader stopWordsReader = new StopWordsReaderImpl(stopWordsReaderConfiguration, fileReaderService);

        wordCounterService = new WordCounterServiceImpl(wordCounter, stopWordsReader);
    }

    @ParameterizedTest
    @MethodSource("wordCountsParameters")
    void should_test_console_word_counts(String userInput, String expectedConsoleMessage) {
        // prepare data
        final ByteArrayOutputStream consoleByteArrayOutStream = createConsoleByteArrayOutStream();

        // call the actual word counter service
        wordCounterService.countWords(userInput);

        // assert the result
        final String actualConsoleMessage = consoleByteArrayOutStream.toString();
        assertEquals(expectedConsoleMessage, actualConsoleMessage);
    }

    private static Stream<Arguments> wordCountsParameters() {
        return Stream.of(
                Arguments.of("word word word1 word2", createExpectedConsoleOutput(2)),
                Arguments.of("word word word word3", createExpectedConsoleOutput(3)),
                Arguments.of("  word            word1        ", createExpectedConsoleOutput(1)),
                Arguments.of("wo3rd word1", createExpectedConsoleOutput(0)),
                Arguments.of(" word     word word3   wo22rd word", createExpectedConsoleOutput(3))
        );
    }

    private static ByteArrayOutputStream createConsoleByteArrayOutStream() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream resultOutputStream = new PrintStream(byteArrayOutputStream);

        System.setOut(resultOutputStream);

        return byteArrayOutputStream;
    }

    private static String createExpectedConsoleOutput(final int expectedWordCount) {
        return String.format(EXPECTED_RESULT_TEMPLATE, expectedWordCount);
    }

}
