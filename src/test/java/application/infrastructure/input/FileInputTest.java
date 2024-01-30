package application.infrastructure.input;

import application.infrastructure.exceptions.NoFileFoundException;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static application.infrastructure.InfrastructureConstants.NO_SUCH_FILE;
import static org.junit.jupiter.api.Assertions.*;

class FileInputTest {

    @Test
    void getInputBasedOnFile() {
        // given
        final String fileName = "stopwords.txt";
        final ClassLoader classLoader = getClass().getClassLoader();
        final Input fileInput = new FileInput(classLoader.getResource(fileName).getPath());
        final String expectedResult = "the a on off ";

        // when
        final String result = fileInput.getInput();

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void getInputBasedOnFileWhenFileIsEmpty() {
        // given
        final String fileName = "emptyFile.txt";
        final ClassLoader classLoader = getClass().getClassLoader();
        final Input fileInput = new FileInput(classLoader.getResource(fileName).getPath());

        // when
        final String result = fileInput.getInput();

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void getInputBasedOnFileWhenFileDoesNotExists() {
        // given
        final String fileName = "bla";
        final ClassLoader classLoader = getClass().getClassLoader();

        final Input fileInput = new FileInput(fileName);

        // when
        final NoFileFoundException exception = assertThrows(NoFileFoundException.class,
                fileInput::getInput);

        // then
        assertEquals(NO_SUCH_FILE, exception.getMessage());
    }
}