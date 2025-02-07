package com.wulpio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

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
    void GIVEN_correct_input_file_WHEN_main_method_is_called_THEN_correct_output_is_printed_to_the_console() {
        String[] args = {"mytext.txt"};

        Main.main(args);

        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", outContent.toString());
    }

}