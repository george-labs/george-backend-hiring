package wordcount;

import file.FileHandler;
import input.InputReaderFactory;
import input.InputReaderFactoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import text.TextAnalytics;
import text.WordExtractor;

import java.io.ByteArrayInputStream;

public class WordCountKataIntegrationTest {

    @Test
    public void testWordCountFlowNoArgs() {
        String[] args = new String[]{};
        String inputString = "Mary had a little lamb";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactoryMock(inputStream));

        TextAnalytics result = wordCountKata.countWords(args, "integration_test_stopwords.txt");

        Assertions.assertEquals(new TextAnalytics(4,4, 4.25, words), result);
    }

    @Test
    public void testWordCountFlowNoArgsComplexInput() {
        String[] args = new String[]{};
        String inputString = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactoryMock(inputStream));

        TextAnalytics result = wordCountKata.countWords(args, "integration_test_stopwords.txt");

        Assertions.assertEquals(new TextAnalytics(7,6, 6.428571428571429, words), result);
    }

    @Test
    public void testWordCountFlowFileInputArgs() {
        String[] args = new String[]{"integration_test_input.txt"};
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());

        TextAnalytics result  = wordCountKata.countWords(args, "integration_test_stopwords.txt");

        Assertions.assertEquals(new TextAnalytics(4,4, 4.25, words), result);
    }
}
