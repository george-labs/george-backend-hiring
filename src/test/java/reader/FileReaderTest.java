package reader;

import org.junit.jupiter.api.Test;
import service.reader.FileReader;
import service.reader.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    @Test
    void readFile(){
        Reader fileReader = new FileReader();
        assertFalse(fileReader.readInput().isBlank());
    }
}
