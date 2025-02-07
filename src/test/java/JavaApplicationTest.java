import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaApplicationTest {

    @Test
    public void dummyTest() {
        assertTrue(true);
    }

    @Test
    public void emptyString() {
        var input = "";

        var result = JavaApplication.countWords(input);

        assertEquals(0, result);
    }

    @Test
    public void match() {
        var input = "abc";
        var pattern = Constants.PATTERN;

        var result = input.matches(pattern);

        assertTrue(result);
    }

    @Test
    public void matchFail() {
        var input = "abc1";
        var pattern = Constants.PATTERN;

        var result = input.matches(pattern);

        assertFalse(result);
    }

    @Test
    public void countWords() {
        var input = "abc1 ads";

        var result = JavaApplication.countWords(input);

        assertEquals(1, result);
    }

    @Test
    public void req1Check() {
        var input = "Mary had a little lamb";

        var result = JavaApplication.countWords(input);

        assertEquals(5, result);
    }

    @Test
    public void test() {
        JavaApplication.readStopWords();
        assertTrue(true);
    }
}
