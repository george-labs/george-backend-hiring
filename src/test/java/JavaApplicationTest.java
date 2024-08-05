import org.junit.jupiter.api.BeforeEach;
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
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("Mary! had. a? little, lamb.", 5),
                Arguments.of("Mary! had. a? stopWord, lamb.", 4),
                Arguments.of("Mary&^had a little la1mb", 2),
                Arguments.of(" ", 0)
        );
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("provideTextAndExpectedWordCount")
    public void countWords_countValidWords(String text, long expected) {
        provideInput(text);
        JavaApplication.main(new String[]{});
        assertEquals("Enter text: Word count: " + expected , outputStreamCaptor.toString().trim());

    }


}
