import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileReaderTest {
    @Test
    public void testWithMytextFile() throws IOException {
        FileReader fileReader = new FileReader("mytext.txt");
        String  actualStr = fileReader.readFile();

        Assertions.assertEquals("Mary had\n" +
                "a little\n" +
                "lamb\n", actualStr);
    }
    @Test
    public void testWithWrongFileName() throws IOException {
        FileReader fileReader = new FileReader("mtext.txt");
        String  actualStr = fileReader.readFile();

        Assertions.assertEquals("", actualStr);
    }
}
