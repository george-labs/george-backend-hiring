import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JavaApplicationTest {

    JavaApplication javaApplication;

    @BeforeEach
    void setup() {
        this.javaApplication = new JavaApplication();
    }

    @Test
    void countWord() {

        String input = "Mary had a little lamb";
        int expected = 5;
        Assertions.assertEquals(expected, JavaApplication.countWord(input));
    }

    @Test
    void countWordNumber() {

        String input = "Mary55 had a little lamb 55";
        int expected = 4;
        Assertions.assertEquals(expected, JavaApplication.countWord(input));
    }

    @Test
    void countWordNullInput() {
        String input = null;
        int expected = 0;
        Assertions.assertEquals(expected, JavaApplication.countWord(input));
    }


    @Test
    void countWordEmptyInput() {
        String input = "";
        int expected = 0;
        Assertions.assertEquals(expected, JavaApplication.countWord(input));
    }

    @Test
    void countWordWhiteSpaceInput() {
        String input = " ";
        int expected = 0;
        Assertions.assertEquals(expected, JavaApplication.countWord(input));
    }

    @Test
    void countWordsExceptStopWords() throws IOException {
        String input = "Mary had a little lamb";
        int expected = 4;
        Assertions.assertEquals(expected, javaApplication.countWordExceptStopWords(input));
    }

    @Test
    void countWordsExceptStopWordsWithNumber() throws IOException {
        String input = "Mary had a little lamb55";
        int expected = 3;
        Assertions.assertEquals(expected, javaApplication.countWordExceptStopWords(input));
    }

    @Test
    void countWordFromFileNotExist() throws IOException {
        String input = "Mary had a little lamb55";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int expected = 3;
        Assertions.assertEquals(expected, javaApplication.countWordsFromFile(null));
    }

    @Test
    void countFromFileExist() throws IOException {
        var input = this.getClass().getClassLoader().getResource("mytext.txt").getPath();
        var expected = 4;
        Assertions.assertEquals(expected, javaApplication.countWordsFromFile(input));
    }

    @Test
    void countFromFileExistContainsNumber() throws IOException {
        var input = this.getClass().getClassLoader().getResource("mytext_number.txt").getPath();
        var expected = 3;
        Assertions.assertEquals(expected, javaApplication.countWordsFromFile(input));
    }

    @Test
    void countUniqueWords() throws IOException {

        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        var expected = List.of(9, 7);

        Assertions.assertEquals(expected, javaApplication.countWordsFromFileDashAsSpace(null));
    }

    @Test
    void countUniqueWordsFromFile() throws IOException {

        var input = this.getClass().getClassLoader().getResource("countUnique.text").getPath();
        var expected = List.of(9, 7);

        Assertions.assertEquals(expected, javaApplication.countWordsFromFileDashAsSpace(input));
    }

    @Test
    void countWordAndUniqueWordsFromInvalidFile() throws IOException {
        var input = this.getClass().getClassLoader().getResource("countUnique.text").getPath();
        var expected = List.of(9, 7);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(expected, javaApplication.countWordsFromFileDashAsSpace(input));
    }

    @Test
    void countWordAndUniqueWordHyphenAsWordFromFile() throws IOException {
        var input = this.getClass().getClassLoader().getResource("countUnique.text").getPath();
        var expected = List.of(7, 6);
        Assertions.assertEquals(expected, javaApplication.countWordsFromFileHyphenAsWord(input));
    }

    @Test
    void countWordAndUniqueWordHyphenAsWordFromInput() throws IOException {
        var input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        var expected = List.of(7, 6);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(expected, javaApplication.countWordsFromFileHyphenAsWord(null));
    }
}
