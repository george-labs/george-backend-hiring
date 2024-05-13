import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcount.InputReader;
import wordcount.OutputWriter;
import wordcount.StopWordsLoader;
import wordcount.WordCountService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class JavaApplicationTest {
    @Test
    void testWordCountIntegration() {
        String inputText = "Mary had a little lamb";
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        JavaApplication javaApplication = new JavaApplication(new InputReader(), new OutputWriter(), new WordCountService(new StopWordsLoader().loadStopWords("src/main/resources/stopwords.txt")));
        javaApplication.run();

        String outputText = outputStream.toString();
        Assertions.assertEquals("Enter text: Number of words: 4", outputText.trim());
    }
}
