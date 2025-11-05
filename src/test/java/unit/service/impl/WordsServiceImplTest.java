package unit.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.impl.WordsServiceImpl;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordsServiceImplTest {

    private WordsServiceImpl wordsService;
    private Set<String> stopWords;

    @BeforeEach
    void setUp() {
        wordsService = new WordsServiceImpl();
        stopWords = Set.of("the", "a", "on", "off");
    }

    private static Stream<Arguments> provideArgsForCountWordsTest() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("  ", 0),
                Arguments.of("Mary had a little lamb", 4),
                Arguments.of("Mary. had1 the little lamb", 2),
                Arguments.of("Mary had    a little lamb", 4),
                Arguments.of("Mary had off little\n lamb", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForCountWordsTest")
    void test_countWords_shouldReturnExpected(String text, int expected) {
        assertEquals(expected, wordsService.countWords(text, stopWords));
    }

    @Test
    void givenNullText_whenCountWords_thenShouldThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> wordsService.countWords(null, stopWords));
    }

}
