import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFileStopWordsTest {
    @Test
    public void testStopWords() {
        List<String> result = new TextFileStopWords().provideStopWords();

        assertEquals(5, result.size());
    }
}
