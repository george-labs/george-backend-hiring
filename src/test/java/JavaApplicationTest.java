import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

    JavaApplication javaApplication;

    @BeforeEach
    void setup(){
        this.javaApplication=new JavaApplication();
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
    void countWordsExceptStopWords() {
        String input = "Mary had a little lamb";
        int expected = 4;
        Assertions.assertEquals(expected, javaApplication.countWordExceptStopWords(input));
    }

    @Test
    void countWordsExceptStopWordsWithNumber() {
        String input = "Mary had a little lamb55";
        int expected = 3;
        Assertions.assertEquals(expected, javaApplication.countWordExceptStopWords(input));
    }
}
