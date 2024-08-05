import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wordcounter.InputUtils.provideInput;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static Stream<Arguments> provideTextAndExpectedWordCount() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 5, 5),
                Arguments.of("Mary lamb a little lamb", 5, 4),
                Arguments.of("Mary! had. a? little, lamb.", 5, 5),
                Arguments.of("Mary! had. a? stopWord, lamb.", 4, 4),
                Arguments.of("Mary&^had a little la1mb", 2, 2),
                Arguments.of(" ", 0, 0)
        );
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("provideTextAndExpectedWordCount")
    public void countWords_userInput_countsValidWords(String text, long expectedCount, int expectedUnique) {
        provideInput(text);
        JavaApplication.main(new String[]{});
        assertEquals(String.format("Enter text: Number of words: %d, unique: %d", expectedCount, expectedUnique), outputStreamCaptor.toString().trim());
    }

    @Test
    public void countWords_fileInput_countsValidWords() {
        JavaApplication.main(new String[]{"mytext.txt"});
        assertEquals("Number of words: 4, unique: 4", outputStreamCaptor.toString().trim());
    }

}
