package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static final String STOPWORDS_TXT = "stopwords.txt";

    public static List<String> readStopWordsFromResources() {
        List<String> stopWords = new ArrayList<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // OR MAIN THREAD?
        try (InputStream inputStream = classLoader.getResourceAsStream(STOPWORDS_TXT)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + STOPWORDS_TXT);
            } else {
                try (InputStreamReader streamReader =
                             new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                     BufferedReader reader = new BufferedReader(streamReader)) {

                        String line;
                    while ((line = reader.readLine()) != null) {
                        stopWords.add(line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource file: " + STOPWORDS_TXT, e);
        }

        return stopWords;
    }
}
