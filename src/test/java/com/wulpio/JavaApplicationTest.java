package com.wulpio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

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

    @ParameterizedTest
    @CsvSource({
            ",0,0",
            " ,0,0",
            "\n,0,0",
            "\\n,0,0",
            "test,1,1",
            "Mary had a little lamb,4,4",
            "Mary! had a little lamb,3,3",
            "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.,7,5",
            "dsa sad 1231@ 213 \",2,2"
    })
    void GIVEN_sentence_from_parameter_WHEN_getCountOfWords_THEN_correct_number_of_words_is_returned(String inputText, int count, int uniqueCount) {
        var javaApplication = new JavaApplication();

        WordCounterDto words = javaApplication.getCountOfWords(inputText);

        assertEquals(count, words.wordCount());
        assertEquals(uniqueCount, words.uniqueWordCount());
    }

    @Test
    void GIVEN_existing_file_with_4_words_WHEN_readLineAndCountWords_THEN_4_number_of_words_is_written_on_console() {
        var javaApplication = new JavaApplication();

        javaApplication.readContentAndCountWords("myText.txt");
        assertEquals("Number of words: 4, unique: 4", outContent.toString());
    }

    @Test
    void GIVEN_non_existing_file_WHEN_readLineAndCountWords_THEN_console_input_is_read_and_1_number_is_written_on_console() {
        var javaApplication = new JavaApplication();
        String simulatedInput = "Baeldung";

        openStream(simulatedInput);
        javaApplication.readContentAndCountWords("not_exist");
        closeStream();

        assertEquals("Enter text: Number of words: 1, unique: 1", outContent.toString());
    }

    @Test
    void GIVEN_null_as_input_WHEN_readLineAndCountWords_THEN_console_input_is_read_and_1_number_is_written_on_console() {
        var javaApplication = new JavaApplication();
        String simulatedInput = "Baeldung";

        openStream(simulatedInput);
        javaApplication.readContentAndCountWords(null);
        closeStream();

        assertEquals("Enter text: Number of words: 1, unique: 1", outContent.toString());
    }

    private static void openStream(String simulatedInput) {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    private static void closeStream() {
        new Scanner(System.in).close();
    }

}
