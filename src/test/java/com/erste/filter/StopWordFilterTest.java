package com.erste.filter;

import com.erste.util.ResourceFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StopWordFilterTest {

    private final WordFilter stopWordsFilter = new StopWordFilter(new ResourceFileReaderMock());

    @Test
    void testFilter() {
        List<String> input = List.of("Mary", "on", "had", "a", "little", "off", "the", "lamb");

        List<String> expectedResult =  List.of("Mary", "had", "little", "lamb");

        List<String> result = stopWordsFilter.filter(input);

        Assertions.assertTrue(expectedResult.containsAll(result));
        Assertions.assertEquals(expectedResult.size(), result.size());
    }


    private class ResourceFileReaderMock extends ResourceFileReader {
        @Override
        public List<String> readFile(String filename) {
            return List.of(
                    "a",
                    "the",
                    "off",
                    "on"
            );
        }
    }
}
