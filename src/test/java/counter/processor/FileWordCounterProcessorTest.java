package counter.processor;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWordCounterProcessorTest extends AbstractCounterProcessorTest {

    WordCounterProcessor sut;

    @Test
    void testProcessEnd2End() {
        sut = new FileWordCounterProcessor(createTestWordCounter());

        final String output = sut.process("src/test/resources/inputwords.txt");

        assertEquals("Number of words: 8", output, "There should be 8 allowed words in file");
    }

}