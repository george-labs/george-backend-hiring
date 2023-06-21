package service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReaderServiceTest {

    private final ReaderService readerService = new ReaderService();

    @Test
    public void testRead_shouldReadFromConsole_whenInputFileIsBlank() {
        String data = "Mary had a lamb";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(4, inputStrings.size());
        assertResult(data, inputStrings);
    }

    @Test
    public void testRead_shouldReadFromConsole_whenInputFileIsBlankAndInputTextIsBlank() {
        String data = "\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(1, inputStrings.size());
    }

    @Test
    public void testRead_shouldReadFromFile_whenInputFileIsGiven() {
        String fileName = "wordsToCount.txt";
        List<String> inputStrings = readerService.read(fileName);
        assertEquals(5, inputStrings.size());
    }

    @Test
    public void testRead_shouldThrowException_whenReadFromFileHasInvalidFile() {
        String fileName = "test.txt";
        assertThrows(RuntimeException.class, () -> readerService.read(fileName));
    }

    @Test
    public void testRead_shouldReadFromConsole_whenInputIsConnectedWithDashAndDots() {
        String data = "Mary-had-a-lamb. Mary-had-two-lambs.";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(2, inputStrings.size());

        String expectedResult = "Mary-had-a-lamb Mary-had-two-lambs";
        assertResult(expectedResult, inputStrings);
    }
    @Test
    public void testRead_shouldReadFromConsole_whenInputIsConnectedWithDashAndMultipleDots() {
        String input = "Mary-had..... Mary-had......";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(2, inputStrings.size());

        String expected = "Mary-had Mary-had";
        assertResult(expected, inputStrings);
    }

    @Test
    public void testRead_shouldReadFromConsole_whenInputIsConnectedWithDashes() {
        String input = "Mary-had-two-huge-lambs.";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(1, inputStrings.size());

        String expected = "Mary-had-two-huge-lambs";
        assertResult(expected, inputStrings);
    }

    @Test
    public void testRead_shouldReadFromConsole_whenOnlyDashIsGiven() {
        String input = "-";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> inputStrings = readerService.read("");
        assertEquals(1, inputStrings.size());

        String expected = "-";
        assertResult(expected, inputStrings);
    }

    private void assertResult(String expected, List<String> actual) {
        List<String> expectedWords = Arrays.asList(expected.split(" "));
        for (int i = 0; i < expectedWords.size(); i++) {
            assertEquals(expectedWords.get(i), actual.get(i));
        }
    }
}
