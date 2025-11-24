package counter.processor;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class StringWordCounterProcessorTest extends AbstractCounterProcessorTest {

    WordCounterProcessor sut;

    @ParameterizedTest
    @MethodSource("testProcessEnd2EndTestCases")
    void testProcessEnd2End(String input, int expectedCount) {
        sut = new StringWordCounterProcessor(createTestWordCounter());

        String output = sut.process(input);
        assertEquals(String.format("Number of words: %s", expectedCount), output);
    }

    @ParameterizedTest
    @MethodSource("testProcessTestCases")
    void testProcess(int expectedCount) {
        sut = new StringWordCounterProcessor(input -> expectedCount);
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

    public static Stream<Arguments> testProcessEnd2EndTestCases() {
        return Stream.of(
                Arguments.of("Hi, what is your name?", 5),
                Arguments.of("a what?", 1),
                Arguments.of("Turn light off", 2),
                Arguments.of("what with A", 2)
        );
    }
}