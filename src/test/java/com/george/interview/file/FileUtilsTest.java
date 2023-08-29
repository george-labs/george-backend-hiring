package com.george.interview.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileUtilsTest {
    @Test
    public void testReadFile() {
        List<String> lines = FileUtils.getFileLines("hello\nworld".getBytes());
        Assertions.assertEquals(2, lines.size());
        Assertions.assertEquals("hello", lines.get(0));
        Assertions.assertEquals("world", lines.get(1));
    }
}
