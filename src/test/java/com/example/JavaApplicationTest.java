package com.example;

import com.example.testutils.TestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class JavaApplicationTest {

    @Test
    public void testCorrectOutput() {
        TestHelper.provideInput("Mary had a little lamb");
        ByteArrayOutputStream testOut = TestHelper.provideOutput();

        JavaApplication.main(new String[0]);

        String output = testOut.toString().trim();
        Assertions.assertNotNull(output);
        System.out.println(output);
        Assertions.assertTrue(output.endsWith("Number of words: 4"));
    }

    @Test
    public void testIncorrectWordsOutput() {
        TestHelper.provideInput("M4ry ha!d a little lamb");
        ByteArrayOutputStream testOut = TestHelper.provideOutput();

        JavaApplication.main(new String[0]);

        String output = testOut.toString().trim();
        Assertions.assertNotNull(output);
        Assertions.assertTrue(output.endsWith("Number of words: 2"));
    }

    @Test
    public void testWhenTextFileIsAvailable() {
        ByteArrayOutputStream testOut = TestHelper.provideOutput();

        JavaApplication.main(new String[]{"text.txt"});

        String output = testOut.toString().trim();
        Assertions.assertNotNull(output);
        Assertions.assertTrue(output.endsWith("Number of words: 4"));
    }

    @Test
    public void testWhenWhenStopwordsNotAvailable() {
        ByteArrayOutputStream testErr = TestHelper.provideErrOutput();

        new JavaApplication().run("stopw.txt", "text.txt");

        String output = testErr.toString().trim();
        Assertions.assertNotNull(output);
        Assertions.assertTrue(output.endsWith("Stopwords file not found."));
    }

}
