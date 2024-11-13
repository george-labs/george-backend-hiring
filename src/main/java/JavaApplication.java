import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.ClosedFileSystemException;
import java.util.Scanner;

public class JavaApplication {

    private static final WordParser parser = new SelectiveWordParser();

    public static void main(String[] args) {

        int wordCount;
        if (args.length > 0) {
            wordCount = parseFile(args);
        } else {
            wordCount = parseInput();
        }
        System.out.println("Number of words: " + wordCount);
    }

    private static int parseFile(String[] args) {
        File inputFile = new File(args[0]);

        if (!inputFile.exists()) {
            throw new IllegalStateException("File does not exist: " + args[0]);
        }

        int wordCount = 0;
        try (Scanner myReader = new Scanner(inputFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordCount += parser.countWords(data);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return wordCount;
    }

    private static int parseInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = in.nextLine();

        int countWords = parser.countWords(s);
        return countWords;
    }

}
