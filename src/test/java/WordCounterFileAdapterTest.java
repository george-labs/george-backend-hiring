import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;


class WordCounterFileAdapterTest {

    @Test
    void countWithExisting() {
        final Counter wordCounter = new WordCounterFileAdapter("mytext.txt",
                Collections.emptyList(),
                Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING);
        Integer expected = 5;
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWithNotExisting() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new WordCounterFileAdapter("notExisting.txt",
                        Collections.emptyList(),
                        Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING));
    }
}