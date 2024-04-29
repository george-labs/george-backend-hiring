import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class JavaApplicationTest {

    @Test
    public void testMary() {
        String testedString = "Mary had a little lamb";
        int wordCount = JavaApplication.countWords(testedString);
        assertEquals(wordCount, 5);
    }

    @Test
    public void testWithSpecialCharacters() {
        String testedString = "Mary . \n word2jdjdj 333";
        int wordCount = JavaApplication.countWords(testedString);
        assertEquals(wordCount, 1);
    }

    @Test
    public void testEmptyString() {
        String testedString = "";
        int wordCount = JavaApplication.countWords(testedString);
        assertEquals(wordCount, 0);
    }

}
