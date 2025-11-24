package counter;

import counter.model.CountingResult;
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
        CountingResult countingResult = sut.countWords(null);
        assertEquals(0, countingResult.getTotalWordsCount(), "Total Count should be 0");
        assertEquals(0, countingResult.getUniqueWordsCount(), "Unique Count should be 0");
    }

    @Test
    void testCountWordsEmpty() {
        CountingResult countingResult = sut.countWords("");
        assertEquals(0, countingResult.getTotalWordsCount(), "Total Count should be 0");
        assertEquals(0, countingResult.getUniqueWordsCount(), "Unique Count should be 0");
    }

    @ParameterizedTest
    @MethodSource("testCountWordsTestCases")
    void testCountWords(String input, int expectedTotalCount, int expectedUniqueCount) {
        CountingResult countingResult = sut.countWords(input);
        assertEquals(expectedTotalCount, countingResult.getTotalWordsCount(), String.format("Total Count should be %s",  expectedTotalCount));
        assertEquals(expectedUniqueCount, countingResult.getUniqueWordsCount(), String.format("Unique Count should be %s",  expectedUniqueCount));
    }

    public static Stream<Arguments> testCountWordsTestCases() {
        return Stream.of(
                Arguments.of("Hi", 1, 1),
                Arguments.of(" Hi     ", 1, 1),
                Arguments.of("Hi whats up", 3, 3),
                Arguments.of("Hi $%^&*(_ up", 3, 3),
                Arguments.of("                ", 0, 0),
                Arguments.of("""
                        asdasd
                        asda
                        """, 2, 2),
                Arguments.of(" Hi there hi    ", 3, 2)
        );
    }


}