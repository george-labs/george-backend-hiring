import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    public void testCountNumberOfAlphabeticalWords() {
        String textLine = "Hello World 123abc";
        int numberOfWords = JavaApplication.countNumberOfAlphabeticalWords(textLine);
        assertEquals(2, numberOfWords, "Number of words should be 2");
    }
}
