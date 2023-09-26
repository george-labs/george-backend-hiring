import file.FileHandler;
import input.InputReaderFactory;
import wordcount.WordCountKata;
import wordcount.WordExtractor;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");
        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());
        int count = wordCountKata.countWords(args,"stopwords.txt");
        System.out.println("Number of words:" + count);
    }
}
