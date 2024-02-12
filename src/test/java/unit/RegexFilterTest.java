package unit;

import filter.Filter;
import filter.RegexFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.ConsoleInputValidator;
import validator.Validator;

import java.util.List;

// TODO: creating some list of argument for test cases
public class RegexFilterTest {
    private static final String REGEX_ONLY_ALPHABET = "^[a-zA-Z]+$";
    private Validator validator;

    @BeforeEach
    public void initValidator() {
        this.validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
    }

    @Test
    @DisplayName("Filtering for regex. Filtering with the alphabetical words only. Resoult should contains 3 words")
    public void testFilteringAlphabeticalWordsOnly() {
        // given
        List<String> input = List.of("Apple", "Orange", "banana");
        Filter regexFilter = new RegexFilter(validator);

        // when

        // then
        Assertions.assertEquals(3, regexFilter.filter(input).size());
    }
}
