package com.erste.mm.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileReaderTest {

    @Test
    void testReadingStopWordsFile() {
        List<String> read = FileReader.readBuildInStopWords("stopwords.txt");

        Assertions.assertFalse(read.isEmpty());
    }

    @Test
    void testCanReadInputWordsFromFile() {
        List<String> read = FileReader.readWordsInput("mytext.txt");

        Assertions.assertFalse(read.isEmpty());
    }

}
