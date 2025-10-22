import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    private TestOutputWriter outputWriter;
    private InputReader consoleInputReader;
    private InputReader fileinputReader;
    private StopWordsReader stopWordsReader;

    @BeforeEach
    void setUp() {
        // Given
        outputWriter = new TestOutputWriter();

        consoleInputReader = new InputReader() {
            @Override
            public String readInput(String context) {
                return "a b c d";
            }
        };

        fileinputReader = new InputReader() {
            @Override
            public String readInput(String context) {
                return "a b c";
            }
        };

        stopWordsReader = new StopWordsReader() {
            @Override
            public List<String> readStopWords() {
                return List.of("a");
            }
        };
    }

    @Test
    void shouldReadFromFile() {

        // When
        JavaApplication.execute(outputWriter, consoleInputReader, fileinputReader, stopWordsReader, List.of("non_existent_file.txt").toArray(new String[0]));

        // Assert
        assertEquals("Number of words: 2", outputWriter.getResult());
    }

    @Test
    void shouldReadFromConsole() {

        // When
        JavaApplication.execute(outputWriter, consoleInputReader, fileinputReader, stopWordsReader, new String[0]);

        // Assert
        assertEquals("Enter text: Number of words: 3", outputWriter.getResult());
    }
}
