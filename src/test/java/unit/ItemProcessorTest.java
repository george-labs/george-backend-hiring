package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import processor.ItemProcessor;
import processor.Processor;
import validator.ConsoleInputValidator;
import validator.Validator;

import java.util.List;

public class ItemProcessorTest {
    
    private static final String REGEX_ONLY_ALPHABET = "^[a-zA-Z]+$";
    private Validator validator;
    private Processor processor;

    @BeforeEach
    public void initValidator() {
        this.validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        this.processor = new ItemProcessor(this.validator);
    }

    @Test
    @DisplayName("Processing and validating items. Result should be 5")
    public void testItemProcessorCountingWordsOfFive() {
        // given
        List<String> inputs = List.of("Mary", "had",  "a", "little", "lamb");

        // when
        long wordCount = processor.process(inputs);

        // then
        Assertions.assertEquals(5L, wordCount);
    }

    @Test
    @DisplayName("Processing and validating items. Result should be 3")
    public void testItemProcessorCountingWordsOfThree() {
        // given
        List<String> inputs = List.of("Mary", "had",  "a");

        // when
        long wordCount = processor.process(inputs);

        // then
        Assertions.assertEquals(3L, wordCount);

    }

}
