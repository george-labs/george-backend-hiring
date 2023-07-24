package com.quiz.printer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CountPrinterTest {
    @Test
    void should_PrintWordCount_When_InputTextProvided() {
        long count = 5L;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Printer printer = new CountPrinter();
        printer.print(count);
        Assertions.assertEquals("Number of words: " + count, outputStream.toString());
    }
}