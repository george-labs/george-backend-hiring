import impl.loaders.FileLoaderImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoaderImplTest {

    @Test
    public void testLoadExistingFile() throws IOException {
        FileLoaderImpl fileLoader = new FileLoaderImpl();

        List<String> expectedInput = Arrays.asList("Mary", "had", "a", "little", "lamb");
        List<String> loadedInput = fileLoader.loadFile("src/test/resources/mytext/mytext.txt");
        Assertions.assertEquals(expectedInput, loadedInput);

    }

    @Test
    public void testLoadNonExistingFile() {
        FileLoaderImpl fileLoader = new FileLoaderImpl();
        try {
            fileLoader.loadFile("src/test/resources/non_exist.txt");
        } catch (IOException e) {
            Assertions.assertThrows(IOException.class, fileLoader::loadFile);
        }
    }
}