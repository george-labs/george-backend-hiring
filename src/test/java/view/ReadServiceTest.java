package view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadServiceTest {

    ReadService underTest;

    @Test
    public void testGetWordsCountWithOnlyReadWords() {
        init("Mary had a little lamb");

        int wordCount = underTest.getWordsCount();

        assertEquals(5, wordCount);
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddle() {
        init("Mary had 9 little lamb");

        int wordCount = underTest.getWordsCount();

        assertEquals(4, wordCount);
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddleOfAWord() {
        init("Mary had a l1ttle lamb");

        int wordCount = underTest.getWordsCount();

        assertEquals(4, wordCount);
    }

    private void init(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        underTest = new ReadService(new Scanner(System.in));
    }
}
