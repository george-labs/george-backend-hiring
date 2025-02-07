package com.wulpio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void GIVEN_existing_file_with_4_words_WHEN_readLineAndCountWords_THEN_4_number_of_words_is_written_on_console() {
        var javaApplication = new JavaApplication();

        javaApplication.readContentAndCountWords("myText.txt");
        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", outContent.toString());
    }

    @Test
    void GIVEN_non_existing_file_WHEN_readLineAndCountWords_THEN_console_input_is_read_and_1_number_is_written_on_console() {
        var javaApplication = new JavaApplication();
        String simulatedInput = "Baeldung";

        openStream(simulatedInput);
        javaApplication.readContentAndCountWords("not_exist");
        closeStream();

        assertEquals("Enter text: Number of words: 1, unique: 1; average word length: 8.0 characters", outContent.toString());
    }

    @Test
    void GIVEN_null_as_input_WHEN_readLineAndCountWords_THEN_console_input_is_read_and_1_number_is_written_on_console() {
        var javaApplication = new JavaApplication();
        String simulatedInput = "Baeldung";

        openStream(simulatedInput);
        javaApplication.readContentAndCountWords(null);
        closeStream();

        assertEquals("Enter text: Number of words: 1, unique: 1; average word length: 8.0 characters", outContent.toString());
    }

    private static void openStream(String simulatedInput) {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    private static void closeStream() {
        new Scanner(System.in).close();
    }

}
