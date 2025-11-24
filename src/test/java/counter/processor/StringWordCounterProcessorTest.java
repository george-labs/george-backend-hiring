package counter.processor;

import counter.model.CountingResult;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringWordCounterProcessorTest extends AbstractCounterProcessorTest {

    WordCounterProcessor sut;

    @ParameterizedTest
    @MethodSource("testProcessEnd2EndTestCases")
    void testProcessEnd2End(String input, CountingResult countingResult) {
        sut = new StringWordCounterProcessor(createTestWordCounter());

        String output = sut.process(input);
        assertCounterMessage(output, countingResult);
    }

    @ParameterizedTest
    @MethodSource("testProcessTestCases")
    void testProcess(CountingResult countingResult) {
        sut = new StringWordCounterProcessor(input -> countingResult);
        String output = sut.process("foo");
        assertCounterMessage(output, countingResult);
    }

    public static Stream<Arguments> testProcessTestCases() {
        return Stream.of(
                Arguments.of(new CountingResult(1, 1)),
                Arguments.of(new CountingResult(3, 2)),
                Arguments.of(new CountingResult(10000, 1))
        );
    }

    public static Stream<Arguments> testProcessEnd2EndTestCases() {
        return Stream.of(
                Arguments.of("Hi, what is your name?", new CountingResult(5, 5, 3.20)),
                Arguments.of("a what?", new CountingResult(1, 1, 4.0)),
                Arguments.of("Turn light off", new CountingResult(2, 2, 4.5)),
                Arguments.of("what with A", new CountingResult(2, 2, 4.0)),
                Arguments.of("what what A", new CountingResult(2, 1, 4.0)),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", new CountingResult(7, 6, 6.43)),
                Arguments.of("Humpty- --- Humpty Humpty-.", new CountingResult(3, 1, 6.0)),
                Arguments.of("Humpty- , -Humpty-, Humpty-", new CountingResult(3, 1, 6.0))
        );
    }
}