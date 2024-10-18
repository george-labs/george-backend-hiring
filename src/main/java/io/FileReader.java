package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileReader {
    private final static String STOP_WORD_FILE_NAME = "stopwords.txt";

    public List<String> getStopWords() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(STOP_WORD_FILE_NAME);
        IOHandler ioHandler = new IOHandler(inputStream);
        return ioHandler.getAllInputFromStream();
    }

}
