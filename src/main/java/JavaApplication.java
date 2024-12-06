import impl.writers.InputScannerImpl;
import impl.writers.OutputWriterImpl;


public class JavaApplication {

    public static void main(String[] args) {
        InputScannerImpl inputScanner = new InputScannerImpl();
        int output = inputScanner.scanInput();
        OutputWriterImpl outputWriter = new OutputWriterImpl();
        outputWriter.writeToTerminal("\nNumber of words: " + output);
    }
}