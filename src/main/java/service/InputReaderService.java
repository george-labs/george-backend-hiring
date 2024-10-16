package service;

import input.InputReader;
import input.WordsProvider;
import output.OutputWriter;

import java.io.IOException;
import java.util.Collection;

public class InputReaderService {

    private final WordsProvider wordsProvider;
    private final OutputWriter outputWriter;
    private final InputReader inputReader;

    public InputReaderService(WordsProvider wordsProvider, OutputWriter outputWriter, InputReader inputReader) {
        this.wordsProvider = wordsProvider;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public String getInput(String[] args) throws IOException {
        String inputText = null;
        if (checkIfArgumentExists(args)) {
            // TODO: read not only from resources
            Collection<String> words = wordsProvider.getWords(args[0]);
            inputText = String.join(" ", words);
        } else {
            outputWriter.write("Enter text:");
            inputText = inputReader.read();
        }
        return inputText;
    }

    private boolean checkIfArgumentExists(String[] args) {
        return args != null && args.length > 0 && args[0] != null && !args[0].isEmpty();
    }
}
