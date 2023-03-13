import java.io.IOException;
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
        if (runningType.equals(RUNNING_TYPE.CONSOLE)) {
            runConsole();
        }
        else {
            runFile();
        }

    }

    private void runFile() throws IOException {
        StopWordReader stopWordReader = new StopWordReader("stopwords.txt");
        stopWordReader.read();
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.read(args[0]);
        WordCount wordCount = new WordCount();
        WordCountResult result = wordCount.count(text, stopWordReader.getWordsToFilterOut());
        System.out.println("Number of words: " + result.getNumberOfWords() + ", Number of unique words: " + result.getNumberOfUniqueWords());
    }

    private void runConsole() throws IOException {
        Scanner sc = new Scanner(System.in);
        StopWordReader stopWordReader = new StopWordReader("stopwords.txt");
        stopWordReader.read();
        System.out.println("Enter text:");
        String input = sc.nextLine();
        WordCount wordCount = new WordCount();
        WordCountResult result = wordCount.count(input, stopWordReader.getWordsToFilterOut());
        System.out.println("Number of words: " + result.getNumberOfWords() + ", Number of unique words: " + result.getNumberOfUniqueWords());
    }

    private static RUNNING_TYPE parseArgument(String[] args) {
        return args.length == 0 ? RUNNING_TYPE.CONSOLE : RUNNING_TYPE.FILE;
    }

    public static void main(String[] args) throws IOException {
        WordCountApp wordCountApp = new WordCountApp(args);
        wordCountApp.run();
    }
}
