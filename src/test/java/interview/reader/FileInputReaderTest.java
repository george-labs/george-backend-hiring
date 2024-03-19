package interview.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : Xenofon Zinoviou
 */
class FileInputReaderTest {

    private FileInputReader testClass;

    @BeforeEach
    void init() {
        testClass = new FileInputReader();
    }

    @Test
    void test_givenValidFile_shouldReturnFileContentsAsString() {
        String expected = "the\na\non\noff\n ";
        final String output = testClass.readInput();
        Assertions.assertEquals(expected, output);
    }


}
