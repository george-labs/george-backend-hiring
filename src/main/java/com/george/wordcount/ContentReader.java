package com.george.wordcount;

import java.io.IOException;
import java.io.Reader;

public interface ContentReader {
    String readInput(Reader inputStreamReader) throws IOException;
}
