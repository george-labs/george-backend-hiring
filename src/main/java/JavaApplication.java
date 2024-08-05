import wordcounter.ConsolePrinter;
import wordcounter.TextReader;
import wordcounter.WordCounter;

public class JavaApplication {

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        WordCounter wordCounter = new WordCounter();
        ConsolePrinter consolePrinter = new ConsolePrinter();

        String text = textReader.readText();
        long wordCount = wordCounter.countWords(text);
        consolePrinter.printWordCount(wordCount);
    }

}
