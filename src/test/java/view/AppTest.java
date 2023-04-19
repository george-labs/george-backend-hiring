package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    App underTest;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;


    @Test
    public void testGetWordsCountWithOnlyReadWords() {
        init("Mary had a little lamb");

        underTest.application();

        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddle() {
        init("Mary had 9 little lamb");

        underTest.application();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddleOfAWord() {
        init("Mary had a l1ttle lamb");

        underTest.application();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString()
                .trim());
    }

    private void init(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));

        underTest = new App(new Scanner(System.in), new CountService(), System.out);
    }

    @AfterEach
    public void tearDow() {
        System.setOut(standardOut);
    }
}
