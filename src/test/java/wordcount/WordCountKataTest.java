package wordcount;

import file.FileHandler;
import input.InputReaderFactory;
import input.InputReaderFactoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import text.TextAnalytics;
import text.WordExtractor;

import java.io.ByteArrayInputStream;
import java.util.List;

public class WordCountKataTest {

    @Test
    public void testUserInputAnalytics() {
        String[] args = new String[]{};
        String inputString = "Mary had a little lamb";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactoryMock(inputStream));

        TextAnalytics result = wordCountKata.getTextAnalytics(args, "integration_test_stopwords.txt");

        List<String> expectedWords = List.of("Mary", "had", "little", "lamb");
        TextAnalytics expectedAnalytics = new TextAnalytics(4, 4, 4.25, expectedWords);
        Assertions.assertEquals(expectedAnalytics, result);
    }

    @Test
    public void testComplexUserInputAnalytics() {
        String[] args = new String[]{};
        String inputString = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactoryMock(inputStream));

        TextAnalytics result = wordCountKata.getTextAnalytics(args, "integration_test_stopwords.txt");

        List<String> expectedWords = List.of("Humpty-Dumpty", "sat", "on", "wall", "had", "great", "fall");
        Assertions.assertEquals(new TextAnalytics(7,6, 6.428571428571429, expectedWords), result);
    }

    @Test
    public void textFileInputAnalytics() {
        String[] args = new String[]{"integration_test_input.txt"};
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());

        TextAnalytics result  = wordCountKata.getTextAnalytics(args, "integration_test_stopwords.txt");

        List<String> expectedWords = List.of("Mary", "had", "little", "lamb");
        Assertions.assertEquals(new TextAnalytics(4,4, 4.25, expectedWords), result);
    }
}
