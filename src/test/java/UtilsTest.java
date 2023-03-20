import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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
    void getFileFromResourceTest() {
        Assertions.assertNotNull(Utils.getFileFromResources("stopwords.txt"));
    }

    @Test
    void getFileFromResourceTestFailed() {
        Assertions.assertNull(Utils.getFileFromResources("stopwords2.txt"));
    }
    
}
