import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordCountTest {
    @Test
    public void testCountTextWithValidWords() {
        String testString = "this is text";
        int resultValue =  WordCount.countText(testString);
        assertEquals(3, resultValue);
    }

    @Test
    public void testCountTextWithInvalidWords() {
        String testString = "Hello 465388 $%&//§";
        int resultValue =  WordCount.countText(testString);
        assertEquals(0, resultValue);
    }

    @Test
    public void testCountTextWithEmptyText() {
        String testString = "";
        int resultValue =  WordCount.countText(testString);
        assertEquals(0, resultValue);
    }
}
