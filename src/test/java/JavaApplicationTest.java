import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JavaApplicationTest {
    WordEngine wordEngine;
    @BeforeEach
    void init(){
        wordEngine = new WordEngine();
    }
    @Test
    public void test() {
        char ch = 'Z';
        System.out.println((int) ch);

    }

    @Test
    public void letterTest() {
        Assertions.assertTrue(wordEngine.isLetter('A'));
        Assertions.assertTrue(wordEngine.isLetter('Z'));
        Assertions.assertTrue(wordEngine.isLetter('a'));
        Assertions.assertTrue(wordEngine.isLetter('z'));
        Assertions.assertFalse(wordEngine.isLetter('5'));
    }

    @Test
    public void readingTest() {
        Assertions.assertEquals(3, wordEngine.read("Mary too Mary"));
        Assertions.assertEquals(1, wordEngine.read("\"         word                 \""));
        Assertions.assertEquals(4, wordEngine.read("Mary had a little lamb"));
        Assertions.assertEquals(2, wordEngine.read("w0rd"));
        Assertions.assertEquals(0, wordEngine.read("the a on off"));
    }



}
