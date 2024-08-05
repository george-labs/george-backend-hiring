import wordcounter.ResultPrinter;
import wordcounter.StopWordsReader;
import wordcounter.TextReader;
import wordcounter.WordCounter;

public class JavaApplication {

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        StopWordsReader stopWordsReader = new StopWordsReader("stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWordsReader);
        ResultPrinter resultPrinter = new ResultPrinter();

        String text = textReader.readText();
        long wordCount = wordCounter.countWords(text);
        resultPrinter.printWordCount(wordCount);
    }

}
