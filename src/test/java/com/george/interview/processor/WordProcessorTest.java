package com.george.interview.processor;

import com.george.interview.counter.Counter;
import com.george.interview.counter.WordCounter;
import com.george.interview.file.FileReader;
import com.george.interview.file.LocalSystemFileReader;
import com.george.interview.handler.InputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class WordProcessorTest {


    @Test
    public void wordProcessorTest() {
        FileReader fileReader = new LocalSystemFileReader();
        Counter counter = new WordCounter();
        Processor wordProcessor = new WordProcessor(fileReader, counter);
        Assertions.assertDoesNotThrow(() -> {
            wordProcessor.process(new InputData("hello hello", false, new HashSet<>()));
        });

    }
}
