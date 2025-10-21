import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {


    @Test
    void testNominal(){
        String input = "Mary had a little lamb";
        Assertions.assertEquals(5, JavaApplication.getWordCount(input));
    }

    @Test
    void testEmptyCase(){
        String input = "";
        Assertions.assertEquals(0, JavaApplication.getWordCount(input));
    }

    @Test
    void testOneWord(){
        String input = "Mary";
        Assertions.assertEquals(1, JavaApplication.getWordCount(input));
    }

    @Test
    void testNumericChar(){
        String input = "word23";
        Assertions.assertEquals(0, JavaApplication.getWordCount(input));
    }

}
