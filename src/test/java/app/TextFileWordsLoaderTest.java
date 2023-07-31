package app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class TextFileWordsLoaderTest {


    @Test
    public void readTextFromFile(){

        String testText = "This is a test";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testText.getBytes());

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public InputStream getResourceAsStream(String name) {
                return byteArrayInputStream;
            }
        };

        JavaApplication.class.getClassLoader();
    }
}

