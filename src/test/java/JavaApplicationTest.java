import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//integration tests
public class JavaApplicationTest {

    @Test
    public void testMockReader() throws IOException {
        WordCounter wordCounter = JavaApplication.createWordCounter(new MockReader());

        Assertions.assertEquals(4, wordCounter.count());
        Assertions.assertEquals(4, wordCounter.unique());
    }

    static class MockReader implements TextReader {

        @Override
        public List<String> read() throws IOException {
            return new ArrayList<>(List.of("Mary had", "a", "little lamb"));
        }
    }

    @Test
    public void testFromFile() throws IOException {
        TextReader textReader = new FileTextReader("mytext.txt");
        WordCounter wordCounter = JavaApplication.createWordCounter(textReader);

        Assertions.assertEquals(4, wordCounter.count());
        Assertions.assertEquals(4, wordCounter.unique());
    }

}
