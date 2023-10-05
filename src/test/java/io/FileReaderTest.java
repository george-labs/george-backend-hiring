package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileReaderTest {

    @Test
    public void fileReaderMustReturnTheContentsOfAFileAsString() {
        String fileName = "stopwords.txt";

        FileReader fileReader = new FileReader(fileName);

        try {
            String content = fileReader.read();
            Assertions.assertEquals("the,a,on,off", content, "FileReader did not return the right content.");
        } catch (IOException e) {
            Assertions.fail("File should be found");
        }
    }

    @Test
    public void fileReaderMustReturnAnErrorWhenTheFileDoesNotExist() {
        String fileName = "stopwords123.txt";

        FileReader fileReader = new FileReader(fileName);

        Assertions.assertThrows(IOException.class, fileReader::read, "FileReader did not return an error when the file does not exist.");
    }
}
