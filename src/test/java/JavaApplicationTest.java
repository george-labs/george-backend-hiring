import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    public void testCountWords() {
        int count = JavaApplication.countWords("word wor3d");
        assertEquals(3, count);
    }

    @Test
    public void testCountWordsEmpty() {
        int count = JavaApplication.countWords("");
        assertEquals(0, count);
    }

    @Test
    public void testCountWordsMoreNumber() {
        int count = JavaApplication.countWords("word wor3222d");
        assertEquals(3, count);
    }

    @Test
    public void testCountWordsJustDelimiters() {
        int count = JavaApplication.countWords("223");
        assertEquals(0, count);
    }
}
