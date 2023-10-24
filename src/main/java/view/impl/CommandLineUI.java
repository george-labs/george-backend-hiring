package view.impl;

import processor.WordCountProcessor;
import view.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineUI implements UI {


    private final static String BEGINING_TEPMLATE = "Enter text: ";

    private final WordCountProcessor processor;

    public CommandLineUI(WordCountProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void countWords() {
        System.out.print(BEGINING_TEPMLATE);
        String inputFromCommandLine = readInput();
        String wordCounted = processor.processWordCounting(inputFromCommandLine);
        System.out.println(wordCounted);
    }

    private String readInput() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            throw new RuntimeException(e);
        }
    }

}
