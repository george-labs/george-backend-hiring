import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JavaApplicationTest {

    @Test
    public void GIVEN_words_WHEN_countTheWords_THEN_wordsCounted() throws IOException {
        //GIVEN
        String wordsToCount = "Mary had a little lamb";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(wordsToCount.getBytes());
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        JavaApplication javaApplication = new JavaApplication(inputStream, printStream);
        String expectedOutput = "Enter the text: Number of words: 4";

        //WHEN
        javaApplication.countWords();
        outputStreamCaptor.flush();

        //THEN
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
