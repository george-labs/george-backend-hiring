package com.example.utils;

import com.example.JavaApplication;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class ResourceFileHelper {
    public static List<String> getFileLines(String fileName) {
        URL resource = JavaApplication.class.getClassLoader().getResource(fileName);

        if (resource == null) {
            return null;
        }

        try {
            return Files.readAllLines(new File(resource.toURI()).toPath());
        } catch (IOException | URISyntaxException e) {
            return null;
        }
    }
}
