package service.impl;

import service.InputService;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileInputService implements InputService {
    private static String FILE_PATH = "stopwords.txt";
    @Override
    public String getInput() {
        FileReader reader = new FileReader(FILE_PATH);
        return null;
    }
}
