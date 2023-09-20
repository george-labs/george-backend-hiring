package app;

import java.io.IOException;

import app.validation.InputValidator;
import input.InputReader;
import output.OutputWriter;

public class WordCountApp {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final InputValidator inputValidator;
    private final WordCounter wordCounter;

    public WordCountApp(InputReader inputReader, OutputWriter outputWriter, InputValidator inputValidator,
            WordCounter wordCounter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputValidator = inputValidator;
        this.wordCounter = wordCounter;
    }

    public void run() throws IOException {
        String inputLine = inputReader.readLine();
        inputValidator.validateInputLine(inputLine);
        long wordCount = wordCounter.countWords(inputLine);
        outputWriter.writeOutput(wordCount);
    }

}
