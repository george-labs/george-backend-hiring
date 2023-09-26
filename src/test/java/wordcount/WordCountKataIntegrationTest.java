package wordcount;

import file.FileHandler;
import input.UserInputHandler;
import org.junit.jupiter.api.Test;

public class WordCountKataIntegrationTest {

    @Test
    public void testEntireFlow() {
        String
        new WordCountKata(new UserInputHandler(inputStream), new FileHandler(), new WordExtractor()).countWords(
                "integration_test_stopwords.txt");
    }
}
