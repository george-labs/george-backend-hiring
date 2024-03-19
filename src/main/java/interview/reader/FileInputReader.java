package interview.reader;

import interview.exception.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : Xenofon Zinoviou
 */
public class FileInputReader implements InputReader {
    @Override
    public String readInput() {
        ClassLoader classLoader = FileInputReader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("stopwords.txt")) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return bufferedReader.readLine();

        } catch (RuntimeException e) {
            throw new ReaderException("Fail: could not retrieve file");
        } catch (IOException e) {
            throw new ReaderException("Fail: error reading file");
        }
    }
}
