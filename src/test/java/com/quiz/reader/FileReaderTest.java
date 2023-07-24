package com.quiz.reader;

import com.quiz.exception.WordCountFileNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileReaderTest {
    @Test
    void should_ReturnText_When_ProvidedByRelativeFile() {
        String input = "the\n" +
                "a\n" +
                "on\n" +
                "off";
        Reader reader = new FileReader("stopwords.txt");
        Assertions.assertEquals(input, reader.read());
    }

    @Test
    void should_ReturnText_When_ProvidedByAbsoluteFile() {
        String input = "the\n" +
                "a\n" +
                "on\n" +
                "off";
        Reader reader = new FileReader("src/test/resources/stopwords.txt");
        Assertions.assertEquals(input, reader.read());
    }

    @Test
    void should_ReturnText_When_ProvidedByInvalidFile() {
        String input = "the\n" +
                "a\n" +
                "on\n" +
                "off";
        Reader reader = new FileReader("invalid.text");
        Assertions.assertThrows(WordCountFileNotFoundException.class, reader::read);
    }
}