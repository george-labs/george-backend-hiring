package com.erste.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResourceFileReaderTest {

    private final ResourceFileReader resourceFileReader = new ResourceFileReader("src/test/resources");

    @Test
    void testReadStopWordsFile() {
        String filename = "stopwords.txt";
        List<String> expectedResult = List.of("a", "the", "off", "on");

        List<String> result = resourceFileReader.readFile(filename);

        Assertions.assertTrue(expectedResult.containsAll(result));
        Assertions.assertEquals(expectedResult.size(), result.size());
    }
}
