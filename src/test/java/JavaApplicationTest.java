import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {
    @Test
    public void testWordCountWithoutFileInputWithHyphen() {
        String userInput = "Humpty-Dumpty sat on a wall - Humpty-Dumpty had a great fall.";
        String expectedOutput = "Enter text: Number of words: 7, unique: 6";

        assertEquals(expectedOutput, TestHelper.generateOutputWithInput(userInput));
    }

    @Test
    public void testWordCountWithoutFileInputWithoutHyphen() {
        String userInput = "Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.";
        String expectedOutput = "Enter text: Number of words: 9, unique: 7";

        assertEquals(expectedOutput, TestHelper.generateOutputWithInput(userInput));
    }

    @Test
    public void testWordCountWithFileInputWithHyphen() {
        String expectedOutput = "Number of words: 5, unique: 4";

        assertEquals(expectedOutput, TestHelper.generateOutputWithFile("src/test/resources/text-with-hyphen.txt"));
    }

    @Test
    public void testWordCountWithFileInputWithoutHyphen() {
        String expectedOutput = "Number of words: 6, unique: 5";

        assertEquals(expectedOutput, TestHelper.generateOutputWithFile("src/test/resources/text-without-hyphen.txt"));
    }
}
