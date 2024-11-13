import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaApplication {

    private static final WordParser parser = new SelectiveWordParser();
    private static final Reporter reporter = new Reporter();

    public static void main(String[] args) {

        AnalysisResult analysisResult = doAnalysis(args);
        reporter.report(analysisResult);

        if (args.length > 0 && args[0].equals("-index")) {
            reporter.reportIndex(analysisResult);
        }
    }

    private static AnalysisResult doAnalysis(String[] args) {
        if (args.length > 0 && !args[0].equals("-index")) {
            return parseFile(args[0]);
        }

        return parseInput();
    }


    private static AnalysisResult parseFile(String filePath) {
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            throw new IllegalStateException("File does not exist: " + filePath);
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
