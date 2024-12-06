package com.erste.mm.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StopWordsReaderTest {

    @Test
    void testReadingStopWordsFile() {
        List<String> read = StopWordsReader.readStopWords("stopwords.txt");
        Assertions.assertFalse(read.isEmpty());
    }

}
