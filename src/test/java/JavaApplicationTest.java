import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;


public class JavaApplicationTest {
    WordEngine wordEngine;
    @BeforeEach
    void init(){
        wordEngine = new WordEngine();
    }

    @Test
    public void test() {
        char a = '-';
        System.out.println((int)a);
    }


        @Test
    public void readingTest() {
        Assertions.assertEquals(new WordCountDTO(3,2), wordEngine.read("Mary too Mary"));
        Assertions.assertEquals(new WordCountDTO(1,1), wordEngine.read("\"         word                 \""));
        Assertions.assertEquals(new WordCountDTO(4,4), wordEngine.read("Mary had a little lamb"));
        Assertions.assertEquals(new WordCountDTO(2,2), wordEngine.read("w0rd"));
        Assertions.assertEquals(new WordCountDTO(0,0), wordEngine.read("the a on off"));
        Assertions.assertEquals(new WordCountDTO(0,0), wordEngine.read("!@##$%^&&"));
        Assertions.assertEquals(new WordCountDTO(7,6), wordEngine.read("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
    }










}
