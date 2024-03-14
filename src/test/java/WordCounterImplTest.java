import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class WordCounterImplTest {

    private static Stream<Arguments> provideStringsForGetResultTest() {
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
    @MethodSource("provideStringsForGetResultTest")
    public void getResultScannerResolverTest(String sentence, int expected, int expectedUnique) {
        ByteArrayInputStream bytesIn = new ByteArrayInputStream(sentence.getBytes());
        System.setIn(bytesIn);

        FileReader fileReader = new FileReader();
        WordCounterImpl wordCounterImpl = new WordCounterImpl(new StopWords(fileReader), new WordCounterTestResolver(sentence));

        WordCounterResult result = wordCounterImpl.getResult();
        int count = result.getCount();
        int unique = result.getUnique();

        Assertions.assertEquals(expected, count);
        Assertions.assertEquals(expectedUnique, unique);
    }

    @Test
    public void getResultFileResolverTest() {
        WordCounterFileResolver wordCounterFileResolver = new WordCounterFileResolver(new FileReader(), new String[]{"mytext.txt"});

        FileReader fileReader = new FileReader();
        WordCounterImpl wordCounterImpl = new WordCounterImpl(new StopWords(fileReader), wordCounterFileResolver);

        WordCounterResult result = wordCounterImpl.getResult();
        int count = result.getCount();
        int unique =  result.getUnique();

        Assertions.assertEquals(4, count);
        Assertions.assertEquals(4, unique);
    }
}
