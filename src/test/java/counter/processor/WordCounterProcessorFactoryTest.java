package counter.processor;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCounterProcessorFactoryTest {

    @Test
    void testCreateProcessor() {
        WordCounterProcessor processor = WordCounterProcessorFactory.createProcessor(ProcessorType.FILE);
        assertNotNull(processor, "Processor should not be null");
        assertTrue(processor.getClass().isAssignableFrom(FileWordCounterProcessor.class));
    }

    @Test
    void testCreateEmptyProcessor() {
        assertThrows(IllegalArgumentException.class, () -> WordCounterProcessorFactory.createProcessor(null));

    }
}