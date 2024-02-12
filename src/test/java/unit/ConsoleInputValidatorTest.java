package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.ConsoleInputValidator;
import validator.Validator;

public class ConsoleInputValidatorTest {

    private static final String REGEX_ONLY_ALPHABET = "^[a-zA-Z]+$";

    @Test
    @DisplayName("Validate input. Input should matches with regex ^[a-zA-Z]+$.")
    public void testRegexOnlyAlphabetTrue() {
        // given
        Validator validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        String input = "Apple";

        // when

        // then
        Assertions.assertTrue(validator.isValidInput(input));
    }

    @Test
    @DisplayName("Validate input. Input shouldn't matches with regex ^[a-zA-Z]+$.")
    public void testRegexOnlyAlphabetFalse() {
        // given
        Validator validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        String input = "Appl2e";

        // when

        // then
        Assertions.assertFalse(validator.isValidInput(input));
    }

}
