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
        Assertions.assertEquals(2, WordUtils.countWords(list));
    }

    @Test
    void filterWordsTest() {
        String[] list = {"On12e", "Two", "Thr#4ee*h"};
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

    @Test
    void filterStopWordsTest() {
        List<String> stopWords = List.of("a","the");
        List<String> words = List.of("This","is","a","test","the");
        List<String> expected = List.of("This","is","test");
        Assertions.assertEquals(expected, WordUtils.filterStopWords(words, stopWords));
    }

    @Test
    void filterWordsWhenStopWordsIsEmptyTest() {
       String[] words = {"Th2is","is","a","te23st","the"};
        List<String> expected = List.of("is", "a", "the");
        Assertions.assertEquals(expected, WordUtils.filterWords(words));
    }

    @Test
    void filterWordsUsingAllFiltersTest() {
        List<String> stopWords = List.of("a","the");
        String[] words = {"Th2is","is","a","te23st","the"};
        List<String> expected = List.of("is");
        Assertions.assertEquals(expected, WordUtils.filterWords(words, stopWords));
    }

    // 1. Test file read
    // 2. Test scanner when file does not exist
    // 3. test for input from file

}
