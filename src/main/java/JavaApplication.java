import file.FileHandler;
import input.AppArgumentHandler;
import input.InputReaderFactory;
import text.AnalyticsFormatterFactory;
import text.WordExtractor;
import wordcount.WordCountKata;

public class JavaApplication {
    public static void main(String[] args) {
        System.out.print("Enter text: ");

        var wordCountKata = new WordCountKata(new FileHandler(), new WordExtractor(), new InputReaderFactory());
        var textAnalytics = wordCountKata.getTextAnalytics(args,"stopwords.txt");

        var loadedArgs = new AppArgumentHandler(new FileHandler(), new WordExtractor()).loadArguments(args);
        var formatter = new AnalyticsFormatterFactory().createTextAnalyticsFormatter(loadedArgs);
        System.out.println(formatter.getFormattedData(textAnalytics));
    }
}
