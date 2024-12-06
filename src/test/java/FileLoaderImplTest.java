import api.writers.InputReader;
import impl.writers.InputReaderImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoaderImplTest {

    @Test
    public void testLoadExistingFile() throws IOException {
        InputReader fileLoader = new InputReaderImpl();

        List<String> expectedInput = Arrays.asList("Mary", "had", "a", "little", "lamb");
        List<String> loadedInput = fileLoader.readInput("src/test/resources/mytext/mytext.txt");
        Assertions.assertEquals(expectedInput, loadedInput);

    }

    @Test
    public void testLoadNonExistingFile() {
        InputReaderImpl fileLoader = new InputReaderImpl();
        try {
            fileLoader.readInput("src/test/resources/non_exist.txt");
        } catch (IOException e) {
            Assertions.assertThrows(IOException.class, fileLoader::readInput);
        }
    }
}