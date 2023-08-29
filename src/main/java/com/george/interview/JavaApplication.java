package com.george.interview;

import com.george.interview.counter.Counter;
import com.george.interview.counter.WordCounter;
import com.george.interview.file.FileReader;
import com.george.interview.file.LocalSystemFileReader;
import com.george.interview.handler.InputData;
import com.george.interview.handler.InputHandler;
import com.george.interview.processor.Processor;
import com.george.interview.processor.WordProcessor;

public class JavaApplication {

    public static void main(String[] args) {

        FileReader fileReader = new LocalSystemFileReader();
        Counter counter = new WordCounter();
        Processor processor = new WordProcessor(fileReader, counter);

        InputHandler inputHandler = new InputHandler(fileReader);
        InputData input = inputHandler.getUserInput(args);

        processor.process(input);
    }
}
