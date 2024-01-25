import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopWordFileParserTest {

    private static final Set<String> stopWords = Set.of("a", "the", "on", "off");
    private StopWordFileParser stopWordFileParser = new StopWordFileParser("src/test/resources/stopwords.txt");

    @Test
    public void testParseStopWordsSize() {
        assertEquals(4, stopWordFileParser.parseStopWords().size());
    }

    @Test
    public void testParseStopWords() {
        assertEquals(stopWords, stopWordFileParser.parseStopWords());
    }
}