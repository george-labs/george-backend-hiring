package com.geogre.wordcount;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.security.sasl.SaslServer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    private static final String TEST_INPUT = "The grey goose walks";
    private static final String TEST_INPUT_MIXED = "Let's GO there !";
    private static final String TEST_INPUT_MIXED_NO_CLEAR_WORDS = "Let's p1ck em!";

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final WordCount wordCount = new WordCount();

    @BeforeAll
    public static void beforeAll() {
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    public void beforeEach() {
        outputStream.reset();
    }

    @Test
    void shouldStart() {
        setUpInput(TEST_INPUT);
        wordCount.start();
        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals(4, Integer.parseInt(outputParts[2].trim()));
    }

    @Test
    void shouldStartBlankString() {
        setUpInput(" ");
        wordCount.start();
        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals(0, Integer.parseInt(outputParts[2].trim()));
    }

    @Test
    void shouldStartEmptyString() {
        setUpInput("");
        wordCount.start();
        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals(0, Integer.parseInt(outputParts[2].trim()));
    }

    @Test
    void shouldStartStringWithDigits() {
        setUpInput(TEST_INPUT_MIXED);
        wordCount.start();
        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals(2, Integer.parseInt(outputParts[2].trim()));
    }

    @Test
    void shouldStartStringWithNoClearWords() {
        setUpInput(TEST_INPUT_MIXED_NO_CLEAR_WORDS);
        wordCount.start();
        String[] outputParts = outputStream.toString().split(":");

        if (outputParts.length < 3) {
            fail("The number of parts should be 3: [prompting]: [info]: [number]");
        }
        assertEquals(0, Integer.parseInt(outputParts[2].trim()));
    }

    private void setUpInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}