import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class JavaApplicationTest {
    @Test
    void testCountWords() throws IOException {
        String input = "Mary had a little lamb";
        String expectedOutput = "Enter text: Number of words: 5";

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(inputStream, InputStream.nullInputStream(), outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords() throws IOException {
        String input = "Mary had a little lamb";
        String expectedOutput = "Enter text: Number of words: 4";

        try (InputStream userInputStream = new ByteArrayInputStream(input.getBytes());
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }
}