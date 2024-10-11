package com.example.utils;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class FileHelper {
    public static List<String> getFileLines(String fileName) {
        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (Exception e) {
            return null;
        }
    }
}
