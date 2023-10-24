package service;

import factory.FilterFactory;
import model.Words;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StopWordsFilterImplIntegrationTest {

    @Test
    void testGivenStopWordsAfterFilteringReturnFilteredWords() {
        int expectedSizeFilteredWords = 4;
        String stopWordsFilename = "stopwords-test.txt";
        Filter stopWordsFilter = FilterFactory.createWith(stopWordsFilename);
        Words words = createWords();

        Words filteredWords = stopWordsFilter.filter(words);

        assertEquals(expectedSizeFilteredWords, filteredWords.getWords().size());
    }

    @Test
    void testGivenWrongFileNameThenThrowAnException() {
        String nonExistingFilename = "dummyFilename.txt";
        Filter stopWordsFilter = FilterFactory.createWith(nonExistingFilename);
        Words words = createWords();

        assertThrows(IllegalArgumentException.class, () -> stopWordsFilter.filter(words));
    }

    private Words createWords(){
        List<String> words = List.of("Mary",
                "had",
                "a",
                "little",
                "lamb");

        return new Words(words);
    }
}
