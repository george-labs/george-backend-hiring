package com.erste.filter;

import com.erste.util.ResourceFileReader;

import java.util.List;

public class StopWordFilterTest {


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
