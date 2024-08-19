package com.geogre.wordcount;

import static com.geogre.wordcount.TestConstants.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private static final int PROMPT_MESSAGE_POSITION = 0;
    private static final int INFO_MESSAGE_POSITION = 1;
    private static final int COUNT_NUMBER_POSITION = 2;

    private final WordCounter wordCounter = new WordCounter(SEPARATOR, STOP_LIST);
    private final WordCount wordCount = new WordCount(wordCounter, null);


    @BeforeAll
    public static void beforeAll() {
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    public void beforeEach() {
        outputStream.reset();
    }

    @Test
    public void shouldStart() {
        setUpInput(TEST_INPUT);

        wordCount.start();

        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals("Enter text", outputParts[PROMPT_MESSAGE_POSITION].trim());
        assertEquals("Number of words", outputParts[INFO_MESSAGE_POSITION].trim());
        assertEquals(4, Integer.parseInt(outputParts[COUNT_NUMBER_POSITION].trim()));
    }

    private void setUpInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}