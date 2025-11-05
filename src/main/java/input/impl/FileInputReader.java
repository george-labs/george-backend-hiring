package input.impl;

import input.InputReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;

public class FileInputReader implements InputReader {

    private String fileName;

    public FileInputReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String readInput() throws NoSuchFileException {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Path must not be null!");
        }

        StringBuilder inputText = new StringBuilder();
        fileName = "/" + fileName;

        try (InputStream inputStream = getClass().getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                inputText.append(line + "\n");
            }
        } catch (NullPointerException e) {
            throw new NoSuchFileException("File with name: " + fileName + " doesnt exists");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputText.toString();
    }
}
