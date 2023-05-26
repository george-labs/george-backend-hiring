import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WordProcessorTest {


    @Test
    void countWords() {
        List<String> input = Arrays.asList("merry lamb the","2 2 3 4", "  d on a 34= *ff", "  ");
        int[] expectedOutput = {2, 0, 1,0};

        for (String in: input) {
            int wordsCnt = new WordProcessor(new FileProcessor()).countWords(in, Constants.ACCEPTED_CHARS, Constants.RESOURCE_PATH+ Constants.STOP_WORD_INPUT_SOURCE);
            Assertions.assertEquals(wordsCnt , expectedOutput[input.indexOf(in)]);
        }

    }
}