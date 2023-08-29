package com.george.interview.file;

import java.io.IOException;
import java.net.URISyntaxException;

public interface FileReader {
    byte[] read(String fileName) throws IOException, URISyntaxException;
}
