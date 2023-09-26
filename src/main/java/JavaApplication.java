import file.FileHandler;
import input.UserInputHandler;
import wordcount.WordCountKata;
import wordcount.WordExtractor;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");
        var wordCountKata = new WordCountKata(new UserInputHandler(System.in), new FileHandler(), new WordExtractor());
        int count = wordCountKata.countWords("stopwords.txt");
        System.out.println("Number of words:" + count);
    }
}
