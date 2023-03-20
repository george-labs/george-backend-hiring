import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UtilsTest {

    @Test
    void getFileTest() throws IOException {
        String fileName = "testStopWords.txt";
        File testFile = new File(fileName);
        testFile.createNewFile();
        File loaded = Utils.getFile(fileName);
        Assertions.assertNotNull(loaded, "File not found in App folder!");
        testFile.delete();
    }

    @Test
    void getFileDoesnExists() {
        Assertions.assertNull(Utils.getFile("aaa.txt"));
    }

    @Test
    void getFileFromResourceTest() {
        Assertions.assertNotNull(Utils.getFileFromResources("stopwords.txt"));
    }

    @Test
    void getFileFromResourceTestFailed() {
        Assertions.assertNull(Utils.getFileFromResources("stopwords2.txt"));
    }

    @Test
    void loadFileByLines() {
        List<String> excluded = Utils.loadFileByLines(Utils.getFileFromResources("stopwords.txt"));
        Assertions.assertNotNull(excluded);
        Assertions.assertEquals(4, excluded.size());
    }

    @Test
    void loadFileByLinesNotExists() {
        List<String> excluded = Utils.loadFileByLines(Utils.getFileFromResources("aa.txt"));
        Assertions.assertNotNull(excluded);
        Assertions.assertEquals(0, excluded.size());
    }

    @Test
    void loadInputFromFile() {
        String input = Utils.loadInputFromFile(Utils.getFileFromResources("inputFile1.txt"));
        Assertions.assertEquals("asd asd\non off\noff asd", input);
    }

    @Test
    void loadInputFromNotExistingFile() {
        String input = Utils.loadInputFromFile(Utils.getFileFromResources("aaa.txt"));
        Assertions.assertNull(input);
    }
}
