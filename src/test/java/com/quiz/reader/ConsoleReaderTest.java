package com.quiz.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {
    @Test
    void should_ReturnText_When_ProvidedByConsole(){
        String text = "Mary had a little lamb";
        System.setIn(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)));
        Reader reader = new ConsoleReader();
        Assertions.assertEquals(text, reader.read());
    }
}