import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void splitSentenceWithNumbersTest() {
        String sentence = "One   Two";
        String[] expected = {"One", "Two"};
        Assertions.assertArrayEquals(expected, WordUtils.splitWordsBySpace(sentence));
    }

    @Test
    void countNumbersInListTest(){
        List<String> list = List.of("One", "Two");
        Assertions.assertEquals(2, WordUtils.countWords(list));
    }

    @Test
    void countNumbersInList2Test(){
        List<String> list = List.of("One", "Two");
        Assertions.assertEquals(2,WordUtils.countWords(list));
    }

    @Test
    void filterWords() {
        String[] list = {"On12e", "Two"};
        List<String> filteredWords = WordUtils.filterWords(list);
        Assertions.assertEquals(1, filteredWords.size());
    }

    @Test
    void fullFlowTest() {
        int expected = 2;
        String sentence = "One Two";

        String[] splitedWords = WordUtils.splitWordsBySpace(sentence);
        List<String> filtered = WordUtils.filterWords(splitedWords);
        Assertions.assertEquals(expected, WordUtils.countWords(filtered));

    }

}
