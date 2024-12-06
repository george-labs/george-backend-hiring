import impl.core.InputProcessorImpl;
import impl.loaders.FileLoaderImpl;
import impl.writers.InputScannerImpl;
import impl.writers.OutputWriterImpl;
import java.util.List;
import java.util.Scanner;


public class JavaApplication {

    public static void main(String[] args) {
        FileLoaderImpl fileLoader = new FileLoaderImpl();
        List<String> stopWords = fileLoader.loadFile();

        List<String> input;

        if (args.length < 1) {
            InputScannerImpl inputScanner = new InputScannerImpl(new Scanner(System.in));
            input = inputScanner.scanInput();
        } else {
            input = fileLoader.loadFile(args[0]);
        }

        InputProcessorImpl inputProcessor = new InputProcessorImpl();
        int countedWords = inputProcessor.processScannedInput(input, stopWords);

        OutputWriterImpl outputWriter = new OutputWriterImpl();
        outputWriter.writeToTerminal("\nNumber of words: " + countedWords);
    }
}