import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JavaApplicationTest {

    @Test
    void mainTestWithFile() {
        //arrange
        String[] arguments = new String[] { "mytext.txt" };
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //acts
        JavaApplication.main(arguments);
        //asserts
        Assertions.assertEquals("Number of words: 9, unique: 7", outContent.toString());
    }

    @Test
    void mainTestWithManualEnteringOfText() {
        //arrange
        String[] arguments = new String[] {};
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //acts
        final ByteArrayInputStream inContent = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(inContent);
        JavaApplication.main(arguments);
        //asserts
        Assertions.assertEquals("Enter text:\r\nNumber of words: 9, unique: 7", outContent.toString());
    }
}
