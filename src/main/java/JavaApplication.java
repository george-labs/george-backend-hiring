import java.io.*;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        try (InputStream stopWordInputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt")) {
            countWords(System.in, stopWordInputStream, System.out);
        }
    }

    public static void countWords(InputStream userInputStream, InputStream stopWordInputStream, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("Enter text: ");
        writer.flush();

        StopWordList stopWordList = StopWordList.of(stopWordInputStream);
        WordCounter wordCounter = new WordCounter(WordCounter.SPACE_DELIMITER, WordCounter.ALPHABETIC_WORD_PATTERN, stopWordList);
        Scanner sc = new Scanner(userInputStream);

        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            long wordCount = wordCounter.countWords(line);

            writer.write(String.format("Number of words: %d", wordCount));
            writer.flush();
        }
    }
}