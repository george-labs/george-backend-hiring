package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {

    @Test
    void validate_null_value() {
        assertFalse(StringValidator.matchPattern(null, RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_empty_value() {
        assertFalse(StringValidator.matchPattern("", RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_word() {
        assertTrue(StringValidator.matchPattern("This", RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_white_space_after_the_word() {
        assertFalse(StringValidator.matchPattern("This ", RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_white_space_before_the_word() {
        assertFalse(StringValidator.matchPattern(" This", RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_multiple_words() {
        assertFalse(StringValidator.matchPattern("This Text", RegexPatterns.ALPHABET_PATTERN));
    }

    @Test
    void validate_special_character() {
        assertFalse(StringValidator.matchPattern("This1#", RegexPatterns.ALPHABET_PATTERN));
    }
}
