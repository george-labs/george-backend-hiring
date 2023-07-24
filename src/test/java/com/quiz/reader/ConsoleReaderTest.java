package com.quiz.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {
    @Test
    void should_ReturnText_When_ProvidedByConsole(){
        String text = "Mary had a little lamb";
        Reader reader = new ConsoleReader();
        Assertions.assertEquals(text, reader.read());
    }
}