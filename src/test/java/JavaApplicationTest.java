import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.logging.Logger;

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
}
