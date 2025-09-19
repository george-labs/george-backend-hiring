import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputTest {

    @Test
    public void testWordsFromFile() {
        String words = Input.wordsFromFile("src/test/resources/input.txt");
        assertEquals("Mary had a little lamb", words);
    }

    @Test
    public void testWordsFromConsole() {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/input.txt"))  {

            System.setIn(fileInputStream);
            String words = Input.wordsFromConsole();
            assertEquals("Mary had a little lamb", words);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
}
