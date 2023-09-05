import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterServiceImplTest {

    private static final String EXPECTED_RESULT_TEMPLATE = "Enter text: Number of words: %s\n";

    private WordCounterService wordCounterService;

    @BeforeEach
    void setup() {
        final WordCounter wordCounter = new WordCounterImpl();

        wordCounterService = new WordCounterServiceImpl(wordCounter);
    }

    @ParameterizedTest
    @MethodSource("wordCountsParameters")
    void should_test_console_word_counts(String userInput, String expectedConsoleMessage) {
        // prepare data
        mockUserInput(userInput);
        final ByteArrayOutputStream consoleByteArrayOutStream = createConsoleByteArrayOutStream();

        // call the actual service
        wordCounterService.countWords();

        // assert the result
        final String actualConsoleMessage = consoleByteArrayOutStream.toString();
        assertEquals(expectedConsoleMessage, actualConsoleMessage);
    }

    private static Stream<Arguments> wordCountsParameters() {
        return Stream.of(
                Arguments.of("word word", createExpectedConsoleOutput(2)),
                Arguments.of("word word word", createExpectedConsoleOutput(3)),
                Arguments.of("  word                    ", createExpectedConsoleOutput(1)),
                Arguments.of("wo3rd", createExpectedConsoleOutput(0)),
                Arguments.of(" word     word   wo22rd word", createExpectedConsoleOutput(3))
        );
    }

    private static void mockUserInput(final String userInput) {
        final InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        System.setIn(inputStream);
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
