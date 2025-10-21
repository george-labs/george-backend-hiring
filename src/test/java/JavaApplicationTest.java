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

    @Test
    void testNumericChar2times(){
        String input = "word23 word23";
        Assertions.assertEquals(0, JavaApplication.getWordCount(input));
    }

    @Test
    void testNumericCharwithnonNumericItem(){
        String input = "word23 word";
        Assertions.assertEquals(1, JavaApplication.getWordCount(input));
    }

    @Test
    void testNonAlphaNumeric(){
        String input = "word'd word";
        Assertions.assertEquals(1, JavaApplication.getWordCount(input));
    }


    @Test
    void testNonAlphaNumericCase2(){
        String input = "word^d word";
        Assertions.assertEquals(1, JavaApplication.getWordCount(input));
    }


    @Test
    void testMixedCase(){
        String input = "Mary had a little lamb ignore1 ignore@ 123@123 1'&*/11";
        Assertions.assertEquals(5, JavaApplication.getWordCount(input));
    }



}
