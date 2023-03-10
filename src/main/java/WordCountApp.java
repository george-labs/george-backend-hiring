import java.io.IOException;
import java.util.Scanner;

public class WordCountApp {

    private enum RUNNING_TYPE {
        FILE,
        CONSOLE
    };

    private RUNNING_TYPE runningType;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            StopWordReader stopWordReader = new StopWordReader("stopwords.txt");
            stopWordReader.read();
            System.out.println("Enter text:");
            String input = sc.nextLine();
            WordCount wordCount = new WordCount();
            System.out.println("Number of words: " + wordCount.count(input, stopWordReader.getWordsToFilterOut()));
        }
        else {
            StopWordReader stopWordReader = new StopWordReader("stopwords.txt");
            stopWordReader.read();
            TextFileReader textFileReader = new TextFileReader();
            String text = textFileReader.read(args[0]);
            WordCount wordCount = new WordCount();
            System.out.println("Number of words: " + wordCount.count(text, stopWordReader.getWordsToFilterOut()));
        }

    }


    public static RUNNING_TYPE parseArgument(String[] args) {
        return args.length == 0 ? RUNNING_TYPE.CONSOLE : RUNNING_TYPE.FILE;
    }
}
