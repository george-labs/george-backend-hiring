import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputProviderTest {

    private final FileReader fileReader;
    private final InputProvider inputProvider;

    public InputProviderTest() {
        this.fileReader = new FileReader();
        this.inputProvider = new InputProvider(fileReader);
    }

    @Test
    public void getInputWordsWithPresentFileReturnsExpectedly() {

        String[] params = new String[]{"words.txt"};
        List<String> expected = List.of("mary", "had", "a", "little", "lamb");

        List<String> words = inputProvider.getInputWords(params);

        assertEquals(expected, words);
    }

    @Test
    public void getInputWordsWithoutArgsReturnsExpectedly() {

        String[] params = new String[]{};

        List<String> words = inputProvider.getInputWords(params);

        assertEquals(5, words.size());
    }
}
