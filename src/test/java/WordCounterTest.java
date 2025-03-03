import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class WordCounterTest {

    private final MockFactory mockFactory = new MockFactory();

    @ParameterizedTest
    @CsvSource(
            {" aa vv cc ,3",
             "aa vv cc,3",
             "oo nnbn h h  h,5",
            "aa a0v a-v a ,3",
            " a   a a  a ,0,",
            " b   b b  b ,4"}
    )
    public void countTrimmedStringTest(String line, int expectedCount){
        // mock stopWords list
        List<String> stopWords = mockFactory.getStopWordsList();

        // asserts
        Assertions.assertEquals(expectedCount, WordCounter.count(line, stopWords));
    }

}
