import static impl.writers.utils.InputScannerUtil.readFile;

import impl.writers.utils.InputScannerUtil;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputScannerImplTest {

    @Test
    public void testFilterInputWords() {
        List<String> sourceWords = Arrays.asList("Not", "all", "words", "are", "relevant", "on", "and", "off");
        var forbiddenWords = readFile();

        List<String> filteredInputWords = InputScannerUtil.filterInputWords(sourceWords, forbiddenWords);
        Assertions.assertEquals(6, filteredInputWords.size());
    }
}