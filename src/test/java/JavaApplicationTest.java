import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class JavaApplicationTest {

    @Test
    public void GIVEN_words_WHEN_countTheWords_THEN_wordsCounted() {
        //GIVEN
        JavaApplication javaApplication = new JavaApplication();
        String wordToCount = "Hello world";
        final InputStream original = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(wordToCount.getBytes());
        System.setIn(inputStream);
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String wordsCount = outputStreamCaptor.toString();
        String expectedWordCount = "2";

        //WHEN
        JavaApplication.main(null);


        //THEN
        Assertions.assertEquals(expectedWordCount, wordsCount);
    }

}
