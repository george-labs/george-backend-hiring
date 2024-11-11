import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaApplicationTest {

    @Test
    public void testCountNumberOfAlphabeticalWordsExcludingStopWords() {
        String textLine = "Hello World of the 123abc";
        int numberOfWords = JavaApplication.countNumberOfAlphabeticalWordsExcludingStopWords(
                textLine, List.of("of", "the"));
        assertEquals(2, numberOfWords, "Number of words should be 2");
    }


    @Test
    void testGetStringFromFile() {
        String text = JavaApplication.getStringFromFile("src/test/resources/mytext.txt");
        assertEquals("Mary had\na little\nlamb\n", text,
                "Text should be 'Mary had\na little\nlamb\n'");
    }

    @Test
    void testGetStringFromFileNonExistingFile() {
        assertThrows(RuntimeException.class, () ->
                JavaApplication.getStringFromFile("src/test/resources/NON_EXISTING_FILE.txt"));
    }

}
