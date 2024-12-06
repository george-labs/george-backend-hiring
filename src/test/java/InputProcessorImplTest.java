import static impl.writers.utils.ReadFileUtil.readFile;

import impl.core.InputProcessorImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputProcessorImplTest {

    @Test
    public void testProcessScannedInput() {
        List<String> stopWords = Arrays.asList("a", "on", "off", "the");
        List<String> sourceWords = Arrays.asList("Not", "all", "the", "are", "relevant", "on", "and", "off");

        List<String> filteredInputWords = InputProcessorImpl.filterInputWords(sourceWords, stopWords);

        Assertions.assertEquals(5, filteredInputWords.size());
    }

    @Test
    public void testFilterInputWords() {
        List<String> sourceWords = Arrays.asList("Not", "all", "words", "are", "relevant", "on", "and", "off");
        var forbiddenWords = readFile();

        List<String> filteredInputWords = InputProcessorImpl.filterInputWords(sourceWords, forbiddenWords);
        Assertions.assertEquals(6, filteredInputWords.size());
    }
}