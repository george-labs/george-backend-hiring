package wordcount;

import file.FileHandler;
import input.InputReaderFactory;
import input.InputReaderFactoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class WordCountKataIntegrationTest {

    @Test
    public void testWordCountFlowNoArgs() {
        String[] args = new String[]{};
        String inputString = "Mary had a little lamb";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactoryMock(inputStream));

        int count = wordCountKata.countWords(args, "integration_test_stopwords.txt");

        Assertions.assertEquals(4, count);
    }

    @Test
    public void testWordCountFlowFileInputArgs() {
        String[] args = new String[]{"integration_test_input.txt"};
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());

        int count = wordCountKata.countWords(args, "integration_test_stopwords.txt");

        Assertions.assertEquals(4, count);
    }
}
