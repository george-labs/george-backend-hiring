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
    public void testStopwordsWithStopwordsIsNull() {
        TestHelper.provideInput("M4ry ha!d a little lamb");
        ByteArrayOutputStream testOut = TestHelper.provideOutput();

        JavaApplication.main(new String[0]);

        String output = testOut.toString().trim();
        Assertions.assertNotNull(output);
        Assertions.assertTrue(output.endsWith("Number of words: 2"));
    }
}
