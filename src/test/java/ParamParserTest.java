import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ParamParserTest {

    @Test
    void testShouldCreateIndex() {
        var paramParser = new ParamParserImpl(new String[]{"-index"});
        Assertions.assertTrue(paramParser.shouldCreateIndex());
    }

    @Test
    void testGetFilename() {
        var paramParser = new ParamParserImpl(new String[]{"-index", "test.txt", "test1.txt"});
        Assertions.assertEquals(Optional.of("test.txt"), paramParser.getFileName());
    }

    @Test
    void testGetDictionaryFilename() {
        var paramParser = new ParamParserImpl(new String[]{"-index", "test.txt", "-dictionary=dict.txt"});
        Assertions.assertEquals(Optional.of("dict.txt"), paramParser.getDictionaryFileName());
    }
}