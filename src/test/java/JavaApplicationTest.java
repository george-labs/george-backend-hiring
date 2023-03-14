import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JavaApplicationTest {

    String inputString = "one two three";
    InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    UserInput userInput = new UserInputImpl(inputStream);

    private final CountWords countWords = new CountWords();


    @Test
    void test() {
        String text = userInput.input();

        int numberOfWords = countWords.count(text);
        assertEquals(3, numberOfWords);

    }
}
