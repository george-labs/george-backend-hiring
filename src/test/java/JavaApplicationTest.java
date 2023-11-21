import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class JavaApplicationTest {
    @Test
    void testCountWords_readFromInputStream() throws IOException {
        String input = "Mary had a little lamb";
        String expectedOutput = "Enter text: Number of words: 5, unique: 5; average word length: 3.60 characters";

        try (InputStream inputStream = new ByteArrayInputStream(input.getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[0]), inputStream, InputStream.nullInputStream(), outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords_readFromInputStream() throws IOException {
        String input = "Mary had a little lamb";
        String expectedOutput = "Enter text: Number of words: 4, unique: 4; average word length: 4.25 characters";

        try (InputStream userInputStream = new ByteArrayInputStream(input.getBytes());
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[0]), userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords_readFromFile() throws IOException {
        String expectedOutput = "Number of words: 4, unique: 4; average word length: 4.25 characters";
        String filePath = JavaApplication.class.getClassLoader().getResource("mytext.txt").getPath();

        try (InputStream userInputStream = InputStream.nullInputStream();
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[] { filePath }), userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords_readFromInputStream_uniqueWordCountDiffers() throws IOException {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        String expectedOutput = "Enter text: Number of words: 7, unique: 6; average word length: 6.43 characters";

        try (InputStream userInputStream = new ByteArrayInputStream(input.getBytes());
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[0]), userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords_readFromInputStream_averageWordCount() throws IOException {
        String input = "This is our special test";
        String expectedOutput = "Enter text: Number of words: 5, unique: 5; average word length: 4.00 characters";

        try (InputStream userInputStream = new ByteArrayInputStream(input.getBytes());
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[0]), userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }

    @Test
    void testCountWordsWithStopWords_readFromInputStream_printIndex() throws IOException {
        String input = "Mary had a little lamb";
        String expectedOutput = "Enter text: Number of words: 4, unique: 4; average word length: 4.25 characters\nIndex:\nhad\nlamb\nlittle\nMary\n";

        try (InputStream userInputStream = new ByteArrayInputStream(input.getBytes());
             InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JavaApplication.countWords(CLIParser.parse(new String[] { "-index" }), userInputStream, stopWordInputStream, outputStream);
            String output = outputStream.toString();

            Assertions.assertEquals(expectedOutput, output);
        }
    }
}