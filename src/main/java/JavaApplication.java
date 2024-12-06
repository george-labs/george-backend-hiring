
import impl.loaders.FileLoaderImpl;
import impl.writers.InputScannerImpl;
import impl.writers.OutputWriterImpl;
import java.util.Scanner;


public class JavaApplication {

    public static void main(String[] args) {
        if (args != null) {
            FileLoaderImpl fileLoader = new FileLoaderImpl();
            fileLoader.loadFile(args[0]);
        }
        InputScannerImpl inputScanner = new InputScannerImpl(new Scanner(System.in));
        int output = inputScanner.scanInput();
        OutputWriterImpl outputWriter = new OutputWriterImpl();
        outputWriter.writeToTerminal("\nNumber of words: " + output);
    }
}