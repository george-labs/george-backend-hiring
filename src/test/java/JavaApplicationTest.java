import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaApplicationTest {

    @Test
    void splitSentenceBySpaceTest() {
        String sentence = "One Two";
        String[] expected = {"One", "Two"};
        Assertions.assertArrayEquals(expected, WordUtils.splitWordsBySpace(sentence));
    }

    @Test
    void splitSentenceWithMultipleSPaceTest() {
        String sentence = "One   Two";
        String[] expected = {"One", "Two"};
        Assertions.assertArrayEquals(expected, WordUtils.splitWordsBySpace(sentence));
    }

    @Test
    void countNumbersInListTest(){
        String[] list = {"One", "Two"};
        Assertions.assertEquals(WordUtils.countWords(list),2);
    }

    @Test
    void fullFlowTest() {
        int expected = 2;
        String sentence = "One Two";
        Assertions.assertEquals(WordUtils.countWords(WordUtils.splitWordsBySpace(sentence)), expected);

    }

}
