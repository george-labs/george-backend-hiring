package counter.filter;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FileStopWordsFilterTest {

    FileStopWordsFilter sut;

    @BeforeEach
    void setUp() {
        sut = new FileStopWordsFilter(Path.of("src/test/resources/stopwords.txt"));
    }

    @ParameterizedTest
    @MethodSource("testIsAllowedTestCases")
    void testIsAllowed(String word, boolean expectedAllowed) {
        boolean allowed = sut.isAllowed(word);
        assertEquals(expectedAllowed, allowed, String.format("Word '%s' is no properly evaluated", word));
    }

    public static Stream<Arguments> testIsAllowedTestCases() {
        return Stream.of(
                Arguments.of("Hi", true),
                Arguments.of("a", false),
                Arguments.of("word", true),
                Arguments.of("off", false),
                Arguments.of("offf", true),
                Arguments.of("", true),
                Arguments.of(null, true)
        );
    }
}