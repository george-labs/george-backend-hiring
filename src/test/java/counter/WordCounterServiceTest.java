package counter;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.*;

class WordCounterServiceTest {

    WordCounterService sut;

    @BeforeEach
    void setUp() {
        sut = new WordCounterService(word -> true);
    }

    @Test
    void testCountWordsNull() {
        long countWords = sut.countWords(null);
        assertEquals(0, countWords, "Count should be 0");
    }

    @Test
    void testCountWordsEmpty() {
        long countWords = sut.countWords("");
        assertEquals(0, countWords, "Count should be 0");
    }

    @ParameterizedTest
    @MethodSource("testCountWordsTestCases")
    void testCountWords(String input, int expectedCount) {
        long countWords = sut.countWords(input);
        assertEquals(expectedCount, countWords, String.format("Count should be %s",  expectedCount));
    }

    public static Stream<Arguments> testCountWordsTestCases() {
        return Stream.of(
                Arguments.of("Hi", 1),
                Arguments.of(" Hi     ", 1),
                Arguments.of("Hi whats up", 3),
                Arguments.of("Hi $%^&*(_ up", 3),
                Arguments.of("                ", 0),
                Arguments.of("""
                        asdasd
                        asda
                        """, 2)
        );
    }


}