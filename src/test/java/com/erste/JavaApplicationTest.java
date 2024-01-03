package com.erste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaApplicationTest {

    @Test
    public void testReadFromFileCounting_thenCorrectMessage() {
        String filename = "mytext.txt";
        String pathToResourceFolder = "src/test/resources/";
        String result = new JavaApplication(pathToResourceFolder).run(new ByteArrayInputStream(filename.getBytes()));

        Assertions.assertEquals("Number of words: 4", result);
    }

}
