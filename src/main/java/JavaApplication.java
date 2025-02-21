import sk.erste.wordcountkata.InputTextReader;
import sk.erste.wordcountkata.WordCounter;
import sk.erste.wordcountkata.WordKata;

public class JavaApplication {

    public static void main(String[] args) {
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        InputTextReader inputTextReader = new InputTextReader(filename);

        WordKata wordKata = new WordKata(inputTextReader);

        try {
            WordCounter.WordCountStat wordCountStat = wordKata.countWords();
            System.out.println("Number of words: " + wordCountStat.wordCount() + ", unique: " + wordCountStat.uniqueWordCount());
        } catch (Exception e) {
            System.out.print("File not found");
        }
    }
}
