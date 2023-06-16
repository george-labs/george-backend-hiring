import exception.IterationException;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JavaApplicationTest {

    @Test
    void testCount_whenEmptySentence_returnIterationException() throws IOException {
        String sentence = "";
        String fileName = "stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        assertThrows(IterationException.class,
                () -> javaApplication.count(sentence));
    }

    @Test
    void testCount_whenCorrectSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a little lamb";
        String fileName = "src/test/resources/stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        int count = javaApplication.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenDuplicateWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had had a little lamb lamb";
        String fileName = "src/test/resources/stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        int count = javaApplication.count(sentence);

        assertEquals(6, count);
    }

    @Test
    void testCount_whenDuplicateStopWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had the little the lamb";
        String fileName = "src/test/resources/stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        int count = javaApplication.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary, had a little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        int count = javaApplication.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInStopWordsInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a, little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        JavaApplication javaApplication = new JavaApplication(fileName);

        int count = javaApplication.count(sentence);

        assertEquals(4, count);
    }
}
