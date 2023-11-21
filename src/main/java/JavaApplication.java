import java.io.*;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        countWords(System.in, System.out);
    }

    public static void countWords(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("Enter text: ");
        writer.flush();

        WordCounter wordCounter = new WordCounter();
        Scanner sc = new Scanner(inputStream);

        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            long wordCount = wordCounter.countWords(line);

            writer.write(String.format("Number of words: %d", wordCount));
            writer.flush();
        }
    }
}