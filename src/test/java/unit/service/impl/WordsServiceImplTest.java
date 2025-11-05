package unit.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.impl.WordsServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordsServiceImplTest {

    private WordsServiceImpl wordsService;

    @BeforeEach
    void setUp() {
        wordsService = new WordsServiceImpl();
    }

    private static Stream<Arguments> provideArgsForCountWordsTest() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("  ", 0),
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("Mary. had1 a little lamb", 3),
                Arguments.of("Mary had    a little lamb", 5),
                Arguments.of("Mary had a little\n lamb", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForCountWordsTest")
    void test_countWords_shouldReturnExpected(String text, int expected) {
        assertEquals(expected, wordsService.countWords(text));
    }

    @Test
    void givenNullText_whenCountWords_thenShouldThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> wordsService.countWords(null));
    }

}
