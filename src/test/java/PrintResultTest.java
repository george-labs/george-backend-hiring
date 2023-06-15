import org.junit.jupiter.api.Test;
import util.PrintResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrintResultTest {
    public PrintResult underTest;

    @Test
    public void testToString() {
        underTest = new PrintResult(6, 5, 6.6);
        String expected = "Number of words: 6, unique: 5; average word length: 6.6";

        String actual = underTest.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        underTest = new PrintResult(7, 5, 6.6);

        PrintResult sameValues = new PrintResult(7, 5, 6.6);
        PrintResult differentWordCount = new PrintResult(8, 5, 6.6);
        PrintResult differentUniqueWordCount = new PrintResult(7, 6, 6.6);
        PrintResult differentAverageWordLength = new PrintResult(7, 5, 6.8);
        boolean actualSameValues = underTest.equals(sameValues);
        boolean actualDifferentWordCount = underTest.equals(differentWordCount);
        boolean actualDifferentUniqueWordCount = underTest.equals(differentUniqueWordCount);
        boolean actualDifferentAverageWordLength = underTest.equals(differentAverageWordLength);

        assertTrue(actualSameValues);
        assertFalse(actualDifferentWordCount);
        assertFalse(actualDifferentUniqueWordCount);
        assertFalse(actualDifferentAverageWordLength);
    }
}
