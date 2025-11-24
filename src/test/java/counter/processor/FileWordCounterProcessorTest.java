package counter.processor;

import counter.model.CountingResult;
import org.junit.jupiter.api.Test;

class FileWordCounterProcessorTest extends AbstractCounterProcessorTest {

    WordCounterProcessor sut;

    @Test
    void testProcessEnd2End() {
        sut = new FileWordCounterProcessor(createTestWordCounter());

        final String output = sut.process("src/test/resources/inputwords.txt");
        CountingResult countingResult = new CountingResult(9, 8, 3.67);
        assertCounterMessage(output, countingResult, "There should be 8 allowed words in file");
    }

}