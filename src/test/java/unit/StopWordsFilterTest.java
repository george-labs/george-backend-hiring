package unit;

import filter.Filter;
import filter.StopWordsFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.FileInputValidator;
import validator.Validator;

import java.util.List;

public class StopWordsFilterTest {

    private static final List<String> LIST_OF_STOP_WORDS = List.of("apple", "rock", "paper");
    private Validator validator;

    @BeforeEach
    public void initStopWordsFilter() {
        this.validator = new FileInputValidator(LIST_OF_STOP_WORDS);
    }

    @Test
    @DisplayName("Filtering for regex. Filtering with the alphabetical words only. Resoult should contains 3 words")
    public void testFilteringAlphabeticalWordsOnly() {
        // given
        List<String> input = List.of("apple", "Orange", "banana");
        Filter stopWordsFilter = new StopWordsFilter(this.validator);

        // when

        // then
        Assertions.assertEquals(2, stopWordsFilter.filter(input).size());
    }


}
