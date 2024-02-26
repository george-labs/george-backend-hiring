package com.george.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StopWordsReader {

    private final String fileName;
    private String data;

    public StopWordsReader(String fileName) throws IOException {
        this.fileName = fileName;
        try {
            read();
        } catch (NullPointerException ex) {
            throw new IOException("File not found");
        }
    }

    public String[] getWords() {
        return data.split("\\R");
    }

    private void read() throws IOException {
        InputStream inputStream = StopWordsReader.class.getResourceAsStream(fileName);
        this.data = readFromInputStream(inputStream);
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
