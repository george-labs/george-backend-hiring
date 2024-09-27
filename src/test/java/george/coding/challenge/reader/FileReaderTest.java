package george.coding.challenge.reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    public void shouldReadTextFromExistingFile() throws IOException {
        // given
        var fileReader = new FileReader("mytext.txt");

        // when
        var result = fileReader.read();

        // then
        assertEquals("Mary had a little lamb", result);
    }

    @Test
    public void shouldThrowNotFoundExceptionOnceFileIsNotFound() {
        // given
        var fileReader = new FileReader("not-existing.txt");

        // when
        // then
        assertThrows(FileNotFoundException.class, () -> fileReader.read());
    }

}