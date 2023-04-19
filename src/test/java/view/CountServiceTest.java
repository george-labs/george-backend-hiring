package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountServiceTest {

    private CountService underTest;

    @BeforeEach
    public void init() {
        underTest = new CountService();
    }

    @Test
    public void testGetWordsCountWithCorrectWords() {
        String input = "Mary had a little lamb";
        int result = underTest.getWordsCount(input, Collections.emptyList());

        assertEquals(5, result);
    }

    @Test
    public void testGetWordsCountDeleteNumberInTheMiddle() {
        String input = "Mary had 9 little lamb";
        int result = underTest.getWordsCount(input, Collections.emptyList());

        assertEquals(4, result);
    }

    @Test
    public void testGetWordsCountDeleteNumberInTheMiddleOfAWord() {
        String input = "Mary had a l1ttle lamb";
        int result = underTest.getWordsCount(input, Collections.emptyList());

        assertEquals(4, result);
    }

    @Test
    public void testGetWordsCountDeleteStoppedWord() {
        String input = "Mary had a little lamb";
        int result = underTest.getWordsCount(input, List.of("a"));

        assertEquals(4, result);
    }
}
