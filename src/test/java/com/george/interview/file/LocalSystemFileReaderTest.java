package com.george.interview.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class LocalSystemFileReaderTest {

    @Test
    void readLocalFileTest() throws IOException, URISyntaxException {
        FileReader localSystemFileReaderTest = new LocalSystemFileReader();
        byte[] content = localSystemFileReaderTest.read("stopwords.txt");
        Assertions.assertTrue(content.length > 0);
    }
}
