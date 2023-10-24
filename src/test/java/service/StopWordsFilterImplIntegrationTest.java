package service;

import model.Words;
import org.junit.jupiter.api.Test;
import repository.StopWordsRepository;
import repository.impl.StopWordsFileRepositoryImpl;
import service.impl.StopWordsFilterImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsFilterImplIntegrationTest {

    private final Filter stopWordFilter;

    public StopWordsFilterImplIntegrationTest() {
        StopWordsRepository stopWordsRepository = new StopWordsFileRepositoryImpl("stopwords-test.txt");
        this.stopWordFilter = new StopWordsFilterImpl(stopWordsRepository);
    }

    @Test
    void testGivenStopWordsAfterFilteringReturnFilteredWords() {
        int expectedSizeFilteredWords = 4;
        Words words = createWords();

        Words filter = stopWordFilter.filter(words);

        assertEquals(expectedSizeFilteredWords, filter.getWords().size());
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
