package com.george.interview.file;

import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static List<String> getFileLines(byte[] content) {
        String[] words = new String(content).split("\n");
        return Arrays.asList(words);
    }
}
