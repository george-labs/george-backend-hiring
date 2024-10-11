package com.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FileHelperTest {

    @Test
    public void testSuccessfulGetFileLines() {
        // Given
        String fileName = "stopwords.txt";
        List<String> expected = Arrays.asList("the", "a", "on", "off");

        // When
        List<String> actual = FileHelper.getFileLines(fileName);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFileNotFoundInGetFileLines() {
        // Given
        String fileName = "stopwor.txt";
        List<String> actual = FileHelper.getFileLines(fileName);


        // Then
        Assertions.assertNull(actual);
    }
}
