package com.geogre.wordcount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileInputFetcher implements InputFetcher {

    private final String inputFilePath;

    public FileInputFetcher(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public String fetch() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        } catch (FileNotFoundException e) {
            System.out.println("File " + inputFilePath + " was not found");
            return "";
        }
    }
}
