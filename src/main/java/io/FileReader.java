package io;

import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;

public class FileReader implements IO {

    private final URL fileUrl;

    public FileReader(String fileName) {
        this.fileUrl = getClass().getClassLoader().getResource(fileName);
    }

    @Override
    public String read() throws IOException {
        if (fileUrl == null) {
            throw new IOException("File not found");
        }

        File file = new File(fileUrl.getFile());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        return bufferedReader.lines().collect(Collectors.joining(","));
    }
}
