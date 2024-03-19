package interview.reader;

import interview.exception.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : Xenofon Zinoviou
 */
public class ConsoleInputReader implements InputReader {

    private final InputStream systemIn;

    public ConsoleInputReader(InputStream systemIn) {
        this.systemIn = systemIn;
    }

    @Override
    public String readInput() {
        System.out.print("Enter text: ");

        try {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(systemIn));
            return buffReader.readLine();
        } catch (RuntimeException ex) {
            throw new ReaderException("Fail: could not retrieve input");
        } catch (IOException ex) {
            throw new ReaderException("Fail: Error reading input");
        }
    }
}
