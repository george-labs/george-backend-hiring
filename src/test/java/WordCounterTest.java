import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCounterTest {

    @ParameterizedTest
    @CsvSource(
            {" aa vv cc ,3",
             "aa vv cc,3",
             "oo nnbn h h  h,5",
            "aa a0v a-v a ,4",
            " a   a a  a ,4"}
    )
    public void countTrimmedStringTest(String line, int expectedCount){
        Assertions.assertEquals(expectedCount, WordCounter.count(line));
    }

}
