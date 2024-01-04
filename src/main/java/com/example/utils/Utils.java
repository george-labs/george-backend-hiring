package com.example.utils;

import java.io.*;
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

    public static String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file:" + filePath, e);
        }

        return builder.toString();
    }
}
