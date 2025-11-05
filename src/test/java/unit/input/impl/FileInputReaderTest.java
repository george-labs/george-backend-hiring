package unit.input.impl;

import input.impl.FileInputReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.NoSuchFileException;

public class FileInputReaderTest {

    private FileInputReader fileInputReader;

    @Test
    void givenValidFileName_whenReadInput_thanShouldReturnFileContent() throws NoSuchFileException {
        fileInputReader = new FileInputReader("mytext.txt");

        assertEquals("Mary had\na little\nlamb\n", fileInputReader.readInput());
    }

    @Test
    void givenInvalidFileName_whenReadInput_thanShouldThrowNoSuchFileException() {
        fileInputReader = new FileInputReader("invalid.txt");

        assertThrows(NoSuchFileException.class, () -> fileInputReader.readInput());
    }

    @Test
    void givenEmptyFileName_whenReadInput_thanShouldThrowIllegalArgumentException() {
        fileInputReader = new FileInputReader("");

        assertThrows(IllegalArgumentException.class, () -> fileInputReader.readInput());
    }

    @Test
    void givenBlankFileName_whenReadInput_thanShouldThrowIllegalArgumentException() {
        fileInputReader = new FileInputReader("    ");

        assertThrows(IllegalArgumentException.class, () -> fileInputReader.readInput());
    }

    @Test
    void givenNullFileName_whenReadInput_thanShouldThrowIllegalArgumentException() {
        fileInputReader = new FileInputReader(null);

        assertThrows(IllegalArgumentException.class, () -> fileInputReader.readInput());
    }

}
