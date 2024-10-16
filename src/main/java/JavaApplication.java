import input.ConsoleInputReader;
import input.InputReader;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.WordCounter;

public class JavaApplication {

    public static void main (String[] args) {
        WordCounter wordCounter = new WordCounter();
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();

        outputWriter.write("Enter text:");

        String inputText = inputReader.read();

        String outputString = "Number of words: " + wordCounter.countWords(inputText);
        outputWriter.write(outputString);
    }
}
