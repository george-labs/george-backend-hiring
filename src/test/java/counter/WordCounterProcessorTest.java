package counter;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterProcessorTest {

    WordCounterProcessor sut;

    @ParameterizedTest
    @MethodSource("testProcessTestCases")
    void testProcess(int  expectedCount) {
        sut = new WordCounterProcessor(input -> expectedCount);
        String output = sut.process("foo");
        assertEquals(output,  String.format("Number of words: %s", expectedCount), "Invalid output");
    }

    public static Stream<Arguments> testProcessTestCases() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(3),
                Arguments.of(10000)
        );
    }
}