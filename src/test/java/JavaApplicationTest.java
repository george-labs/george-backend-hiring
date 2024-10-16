import input.ConsoleInputReader;
import input.FileStopWordsProvider;
import input.InputReader;
import input.StopWordsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.WordCounter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    private StopWordsProvider stopWordsProvider;
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private WordCounter wordCounter;

    @BeforeEach
    void setUp() throws IOException {
        stopWordsProvider = new FileStopWordsProvider();
        inputReader = new ConsoleInputReader();
        outputWriter = new ConsoleOutputWriter();
        wordCounter = new WordCounter(stopWordsProvider.getStopWords("src/test/resources/correct_stop_words.txt"));
    }

    @Test
    public void givenTextInput_whenCountWords_thenReturnCorrectNumberOfWords() {
        //given
        String inputText = "Marry had a little lamb";

        //when
        int numberOfWords = wordCounter.countWords(inputText);

        //then
        assertEquals(4, numberOfWords);
    }
}
