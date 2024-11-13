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
    private static final String REPORT_FORMAT = "Number of words: %d, unique: %d";

    public static void main(String[] args) {

        if (args.length > 0) {
            report(parseFile(args));
        } else {
            report(parseInput());
        }

    }

    private static void report(AnalysisResult analysisResult) {
        System.out.printf((REPORT_FORMAT) + "%n", analysisResult.wordCount, analysisResult.uniqueWordCount);
    }

    private static AnalysisResult parseFile(String[] args) {
        File inputFile = new File(args[0]);

        if (!inputFile.exists()) {
            throw new IllegalStateException("File does not exist: " + args[0]);
        }

        try (Scanner myReader = new Scanner(inputFile)) {
            StringBuilder sb = new StringBuilder();
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }
            return parser.countWords(sb.toString());

        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private static AnalysisResult parseInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = in.nextLine();

        return parser.countWords(s);
    }

}
