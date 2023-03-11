import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WordCountApp {
    enum RUNNING_TYPE {
        FILE,
        CONSOLE
    };
    private RUNNING_TYPE runningType;

    private String[] args;
    public WordCountApp(String[] args) {
        this.args = args;
        this.runningType = parseArgument(args);

    }
    public RUNNING_TYPE getRunningType() {
        return runningType;
    }

    public void run() throws IOException {
        switch (runningType) {
            case FILE:
                runFile();
                break;
            case CONSOLE:
                runConsole();
                break;
        }
    }

    private void runFile() throws IOException {
        List<String> filterList = TextFileReader.read("src/main/resources/stopwords.txt");
        String text = TextFileReader.read(args[0], TextFileReader.JOIN_FUNCTION);
        WordCountResult result = WordCount.count(text, filterList);
        System.out.println(printResult(result));
    }

    private void runConsole() throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> filterList = TextFileReader.read("stopwords.txt");
        System.out.println("Enter text:");
        String input = sc.nextLine();
        WordCountResult result = WordCount.count(input, filterList);
        System.out.println(printResult(result));
    }

    public String printResult(WordCountResult result) {
        return "Number of words: " + result.getNumberOfWords()
                + ", Number of unique words: " + result.getNumberOfUniqueWords()
                + ", average word length: " + result.getAverageWordLength() + " characters";
    }

    private static RUNNING_TYPE parseArgument(String[] args) {
        return args.length == 0 ? RUNNING_TYPE.CONSOLE : RUNNING_TYPE.FILE;
    }

    public static void main(String[] args) throws IOException {
        WordCountApp wordCountApp = new WordCountApp(args);
        wordCountApp.run();
    }
}
