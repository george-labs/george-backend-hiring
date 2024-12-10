import api.writers.InputReader;
import impl.core.InputProcessorImpl;
import impl.writers.InputReaderImpl;
import impl.writers.OutputWriterImpl;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class JavaApplication {

    public static void main(String[] args) throws IOException {
        InputReaderImpl inputReader = new InputReaderImpl(new Scanner(System.in));
        List<String> stopWords = inputReader.readInput();

        List<String> input;

        input = loadInput(args, inputReader);

        InputProcessorImpl inputProcessor = new InputProcessorImpl();
        int countedWords = inputProcessor.processScannedInput(input, stopWords);

        OutputWriterImpl outputWriter = new OutputWriterImpl();
        outputWriter.writeToTerminal("\nNumber of words: " + countedWords);
    }

    private static List<String> loadInput(String[] args, InputReader inputReader) throws IOException {
        List<String> input;
        if (args.length < 1) {
            input = inputReader.readInput();
        } else {
            input = inputReader.readInput(args[0]);
        }
        return input;
    }
}