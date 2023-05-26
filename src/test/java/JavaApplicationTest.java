import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JavaApplicationTest {

    @Test
    public void testCountWordsMethod(){
        String acceptedChars = "^[a-zA-Z]*";
        List<String> input = Arrays.asList("f s e 3f","2 2 3 4", "  d 34= *ff", "  ");
        int[] expectedOutput = {3, 0, 1,0};

        for (String in: input) {
            int wordsCnt = JavaApplication.countWords(in, acceptedChars);
            assert  wordsCnt == expectedOutput[input.indexOf(in)];
        }
    }
}
