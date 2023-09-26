import file.FileHandler;
import input.InputReaderFactory;
import text.TextAnalyticsFormatter;
import text.WordExtractor;
import wordcount.WordCountKata;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");

        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());
        var textAnalytics = wordCountKata.countWords(args,"stopwords.txt");

        System.out.println(new TextAnalyticsFormatter(textAnalytics).getFormattedData());
    }
}
