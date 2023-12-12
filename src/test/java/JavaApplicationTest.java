import org.jetbrains.annotations.NotNull;
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
        String wordToCount = "Hello world";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(wordToCount.getBytes());
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        JavaApplication javaApplication = new JavaApplication(inputStream, printStream);
        String expectedWordCount = "2";

        //WHEN
        javaApplication.countWords();
        outputStreamCaptor.flush();

        //THEN
        Assertions.assertEquals(expectedWordCount, getExpectedWordCount(outputStreamCaptor));
    }

    @NotNull
    private static String getExpectedWordCount(ByteArrayOutputStream outputStreamCaptor) {
        String capturedOutput = outputStreamCaptor.toString();
        String[] splittedOutput = capturedOutput.split("\n");
        return splittedOutput[2];
    }

}
