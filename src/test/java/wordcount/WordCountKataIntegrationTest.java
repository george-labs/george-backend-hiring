package wordcount;

import file.FileHandler;
import input.UserInputHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class WordCountKataIntegrationTest {

    @Test
    public void testEntireFlow() {
        String inputString = "Mary had a little lamb";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new UserInputHandler(inputStream), new FileHandler(), new WordExtractor());

        int count = wordCountKata.countWords(
                "integration_test_stopwords.txt");

        Assertions.assertEquals(4, count);
    }
}
