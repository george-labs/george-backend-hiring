import java.util.Scanner;

public class JavaApplication {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter text: ");
        String sentence = reader.nextLine();
        reader.close();

        WordCounter wc = new WordCounter();

        //try to load excluded words from app folder (if exists) -- uses default otherwise
        wc.loadExcludedWords("./stopwords.txt");

        System.out.println("Number of words: " + wc.countWords(sentence));
    }
}
