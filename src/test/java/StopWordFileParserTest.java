import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopWordFileParserTest {

    private static final List<String> stopWords = List.of("the", "a", "on", "off");
    private InputFileParser stopWordFileParser = new InputFileParser("src/test/resources/stopwords.txt");

    @Test
    public void testParseStopWordsSize() {
        assertEquals(4, stopWordFileParser.parse().size());
    }

    @Test
    public void testParseStopWords() {
        assertEquals(stopWords, stopWordFileParser.parse());
    }
}