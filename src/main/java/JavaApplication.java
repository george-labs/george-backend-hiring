import input.ConsoleInputReader;
import input.InputReader;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.WordCounter;

import java.util.HashSet;

public class JavaApplication {

    public static void main (String[] args) {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();

        outputWriter.write("Enter text:");

        String inputText = inputReader.read();

        String outputString = "Number of words: " + wordCounter.countWords(inputText);
        outputWriter.write(outputString);
    }
}
