import wordcounter.ConsolePrinter;
import wordcounter.StopWordsReader;
import wordcounter.TextReader;
import wordcounter.WordCounter;

public class JavaApplication {

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        StopWordsReader stopWordsReader = new StopWordsReader("stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWordsReader);
        ConsolePrinter consolePrinter = new ConsolePrinter();

        String text = textReader.readText();
        long wordCount = wordCounter.countWords(text);
        consolePrinter.printWordCount(wordCount);
    }

}
