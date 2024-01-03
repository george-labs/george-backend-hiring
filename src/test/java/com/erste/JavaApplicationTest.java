package com.erste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaApplicationTest {

    @Test
    public void testCounting_whenFilenameProvided_thenCorrectMessage() {
        String[] args = new String[]{"mytext.txt"};
        String pathToResourceFolder = "src/test/resources/";
        String result = new JavaApplication(pathToResourceFolder).run(args, null);

        Assertions.assertEquals("Number of words: 4", result);
    }

    @Test
    public void testCounting_whenFilenameNotProvided_thenUseInputText() {
        String[] args = new String[]{};
        String inputText = "Mary has a pretty little sheep";
        String pathToResourceFolder = "src/test/resources/";
        String result = new JavaApplication(pathToResourceFolder).run(args, new ByteArrayInputStream(inputText.getBytes()));

        Assertions.assertEquals("Number of words: 5", result);
    }

}
