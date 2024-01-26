import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {


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
}
