package filereader;

import exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderServiceImplTest {

    private FileReaderService fileReaderService;

    @BeforeEach
    void setup() {
        fileReaderService = new FileReaderServiceImpl();
    }

    @Test
    void should_read_file_from_resources() {
        // prepare data
        final List<String> expectedFileData = List.of("aa", "bb", "cc");

        // call the actual file reader service
        final List<String> actualFileData = fileReaderService.readFileAsList("filereader.txt");

        // assert the data
        assertEquals(expectedFileData, actualFileData);
    }

    @Test
    void should_throw_exception_if_not_found() {
        final String expectedErrorMessage = "File 'some-nonsense.txt' not found";

        final Exception exception = assertThrows(NotFoundException.class, () -> fileReaderService.readFileAsList("some-nonsense.txt"));

        // assert exception message
        final String actualExceptionMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, actualExceptionMessage);
    }

}
