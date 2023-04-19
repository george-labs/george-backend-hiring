package application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import service.CountService;
import service.FileReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAppTest {

    App underTest;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    private void init(String fileName) {
        System.setOut(new PrintStream(outputStreamCaptor));

        underTest = new App(new FileReader(new Scanner(getClass().getClassLoader().getResourceAsStream(fileName))), new CountService(), System.out);
    }

    @Test
    public void testGetWordsCountWithOnlyRealWords() {
        init("onlyrealwords.txt");

        underTest.application();

        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddle() {
        init("numberinmiddle.txt");

        underTest.application();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWordsCountDeleteNumberInTheMiddleOfAWord() {
        init("numberinword.txt");

        underTest.application();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWordsCountDeleteAStopWord() {
        init("containsstopword.txt");

        underTest.application();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDow() {
        System.setOut(standardOut);
    }
}
