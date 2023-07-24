package com.quiz.printer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UniquePrinterTest {
    @Test
    void should_PrintWordUnique_When_InputTextProvided() {
        long unique = 3L;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Printer countPrinter = new CountPrinter();
        Printer uniquePrinter = new UniquePrinter(countPrinter);
        uniquePrinter.print(unique);
        Assertions.assertTrue(outputStream.toString().contains(", unique: " + unique));
    }
}