import java.io.File;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String args[]) {
        String sentence;
        if (args.length == 1) {
            String intputFileName = args[0];
            File inputFile = Utils.getFile(intputFileName);
            if (inputFile == null) {
                System.out.println("Input file was not found!");
                return;
            }
            sentence = Utils.loadInputFromFile(inputFile);
        } else {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter text: ");
            sentence = reader.nextLine();
            reader.close();
        }

        WordCounter wc = new WordCounter();

        //try to load excluded words from app folder (if exists) -- uses default otherwise
        wc.loadExcludedWords("./stopwords.txt");

        System.out.println("Number of words: " + wc.countWords(sentence));
    }
}
