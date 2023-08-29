package com.george.interview.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

public class LocalSystemFileReader implements FileReader {
    @Override
    public byte[] read(String fileName) throws IOException, URISyntaxException {
        //read byte content from local resouce file based on fileName
        if (fileName == null || fileName.isEmpty()) {
            throw new InvalidParameterException("Filename cannot be null or empty");
        }
        try {
            URL fileURL = getClass().getResource(fileName);
            if (fileURL == null) {
                throw new FileNotFoundException("File not found: " + fileName);
            }
            Path filePath = Paths.get(fileURL.toURI());
            return Files.readAllBytes(filePath);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
