package app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TextFileWordsLoaderTest {

    @Test
    public void readTextFromFile(@TempDir Path tempDir) throws IOException {
        String testText = "This is a test";

        Path tempFile = tempDir.resolve("test_mytext.txt");
        Files.write(tempFile, testText.getBytes());

        String result = JavaApplication.readTextFromFile(tempFile.toString());
        assertEquals(testText, result);
    }

    @Test
    public void readTextFromFileNonExistenceFile(){
        try{
            JavaApplication.readTextFromFile("non_existent.txt");
            fail("Excepted RuntimeException to be thrown, but it wasn't.");
        } catch (RuntimeException e){
            System.out.println("Exception is Expected");
        }
    }
}

