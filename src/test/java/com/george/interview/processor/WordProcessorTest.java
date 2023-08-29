package com.george.interview.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordProcessorTest {


    @Test
    public void wordProcessorTest() {
        Processor wordProcessor = new WordProcessor();
        Assertions.assertDoesNotThrow(() -> {wordProcessor.process("hello hello");});

    }
}
