import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class JavaApplicationTest {

    private static Stream<Arguments> provideStringsForMainTest() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 4, 4),
                Arguments.of("word? word. word, wo3rd  word", 2, 1),
                Arguments.of("wo$rd       wo$$        word,    word", 1, 1),
                Arguments.of("wo3rd", 0, 0),
                Arguments.of("the a on off", 0, 0),
                Arguments.of("the a on had off", 1, 1),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 9, 7)
        );
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForMainTest")
    public void mainTest(String sentence, int wordsNumberExpected, int uniqueNumberExpected) {
        ByteArrayInputStream bytesIn = new ByteArrayInputStream(sentence.getBytes());
        System.setIn(bytesIn);

        JavaApplication.main(new String[]{});

        String lines = outputStreamCaptor.toString().trim();

        int lastIndexOf = lines.lastIndexOf(":");

        String unique = lines.substring(lastIndexOf + 2);
        String linesSubstring = lines.substring(0, lastIndexOf);
        lastIndexOf = linesSubstring.lastIndexOf(":");
        String words = linesSubstring.substring(lastIndexOf + 2);
        words = words.substring(0, words.indexOf(","));

        Integer uniqueNumber = Integer.valueOf(unique);
        Integer wordsNumber = Integer.valueOf(words);

        Assertions.assertEquals(wordsNumberExpected, wordsNumber);
        Assertions.assertEquals(uniqueNumberExpected, uniqueNumber);
    }
}
