import sk.erste.wordcountkata.InputTextReader;
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
            int count = wordKata.countWords();
            System.out.println("Number of words: " + count);
        } catch (Exception e) {
            System.out.print("File not found");
        }
    }
}
