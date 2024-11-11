import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaApplicationTest {

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
