import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneSpaceWordCounterTest {
    WordCounter counter;
    WordValidator validator;

    @BeforeEach
    void setup(){
        validator = new EuropeanWordValidator();
        counter = new OneSpaceWordCounter(validator);
    }
    @Test
    void countWords() {
        long count = counter.countWords("asd 123 bb b23 -*/-*/ sss");
        Assertions.assertEquals(3, count);

        count = counter.countWords(" -----");
        Assertions.assertEquals(0, count);

        count = counter.countWords("  ");
        Assertions.assertEquals(0, count);

        count = counter.countWords("𡨸漢 cat 123 ---");
        Assertions.assertEquals(1, count);

        count = counter.countWords("𡨸漢  cat  123 ---");
        Assertions.assertEquals(1, count);
    }
}