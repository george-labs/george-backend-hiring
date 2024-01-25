import io.eras.parser.ClassPathInputFileParser;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassPathInputFileParserTest {

    private static final Set<String> stopWords = Set.of("the", "a", "on", "off");
    private ClassPathInputFileParser stopWordFileParser = new ClassPathInputFileParser("stopwords.txt");

    @Test
    public void testParseStopWordsSize() {
        assertEquals(4, stopWordFileParser.parse().size());
    }

    @Test
    public void testParseStopWords() {
        assertEquals(stopWords, stopWordFileParser.parse());
    }
}