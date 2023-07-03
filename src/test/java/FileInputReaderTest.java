import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputReaderTest {

    @Test
    void testReadInput() throws IOException {
        InputReader fileInputReader = new FileInputReader("src/test/resources/inputFiles/exampleInput.txt");

        String outputString = fileInputReader.readInput();

        assertEquals("Mary had\na little\nlamb", outputString);

    }

}