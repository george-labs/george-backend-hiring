package service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderTest {

    @Test
    public void givenNotExistingFileThenFileReaderShouldReturnEmptyList() {
        FileReader fileReader = new FileReader();
        String filePath = "src/main/resources/dsadsf.txt";

        List<String> lines = fileReader.readFile(filePath);

        assertTrue(lines.isEmpty());
    }

    @Test
    public void givenExistingFileThenFileReaderShouldReturnListOfLines() {
        FileReader fileReader = new FileReader();
        String filePath = "src/main/resources/stoppedWords.txt";

        List<String> lines = fileReader.readFile(filePath);

        assertEquals(3, lines.size());
    }

    @Test
    public void givenExistingEmptyFileThenFileReaderShouldReturnEmptyList() {
        FileReader fileReader = new FileReader();
        String filePath = "src/main/resources/emptyFile.txt";

        List<String> lines = fileReader.readFile(filePath);

        assertTrue(lines.isEmpty());
    }
}
