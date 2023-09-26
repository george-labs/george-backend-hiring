import file.FileHandler;
import input.InputReaderFactory;
import text.TextAnalyticsFormatterFactory;
import text.WordExtractor;
import wordcount.WordCountKata;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");

        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());
        var textAnalytics = wordCountKata.countWords(args,"stopwords.txt");

        var formatter = new TextAnalyticsFormatterFactory().createTextAnalyticsFormatter(args);
        System.out.println(formatter.getFormattedData(textAnalytics));
    }
}
