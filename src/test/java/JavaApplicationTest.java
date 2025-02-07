import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaApplicationTest {

    @Test
    public void dummyTest() {
        assertTrue(true);
    }

    @Test
    public void emptyString() {
        var input = List.of("");

        var result = JavaApplication.countWords(input, Collections.emptyList());

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
        var input = List.of("abc1", "ads");

        var result = JavaApplication.countWords(input, Collections.emptyList());

        assertEquals(1, result);
    }

    @Test
    public void iteration1Test() {
        var input = prepareInput(Constants.MOCK_USER_INPUT);

        var result = JavaApplication.countWords(input, Collections.emptyList());

        assertEquals(5, result);
    }

    @Test
    public void stopWordsCheck() {
        var input = prepareInput(Constants.MOCK_USER_INPUT);
        List<String> stopWords = new ArrayList<>();
        stopWords.add("a");

        var result = JavaApplication.countWords(input, stopWords);

        assertEquals(4, result);
    }

    @Test
    public void test() {
        var path = Constants.STOP_WORDS_PATH;

        JavaApplication.readStopWords(path);

        assertTrue(true);
    }

    @Test
    public void iteration2Test() {
        var input = prepareInput(Constants.MOCK_USER_INPUT);

        var result = JavaApplication.countWords(input, getDummyStopWordsList());

        assertEquals(4, result);
    }

    @Test
    public void emptyStopWords() {
        var input = prepareInput(Constants.MOCK_USER_INPUT);

        var result = JavaApplication.countWords(input, Collections.emptyList());

        assertEquals(5, result);
    }

    @Test
    public void d() {
        var input = prepareInput(Constants.MOCK_USER_INPUT);

        var result = JavaApplication.countWords(input, Collections.emptyList());

        assertEquals(5, result);
    }

    private List<String> getDummyStopWordsList() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
        return stopWords;
    }

    private List<String> prepareInput(String line) {
        return List.of(line.split(Constants.DELIMETER));
    }
}
