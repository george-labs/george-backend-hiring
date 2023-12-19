import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParamParserTest {

    @Test
    void testShouldCreateIndex() {
        var paramParser = new ParamParser(new String[]{"-index"});
        Assertions.assertTrue(paramParser.shouldCreateIndex());
    }

    @Test
    void testGetFilename() {
        var paramParser = new ParamParser(new String[]{"-index", "test.txt"});
        Assertions.assertEquals("test.txt", paramParser.getFileName());
    }
}