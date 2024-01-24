public class WordCounterManager {
    private final WordCounterEngine wordCounterUtility;
    private final WordsPrinter printer;

    public WordCounterManager(WordCounterEngine wordCounterUtility, WordsPrinter printer) {
        this.wordCounterUtility = wordCounterUtility;
        this.printer = printer;
    }

    public void process(String sentence){
        String[] words = wordCounterUtility.senteceSplitter(sentence, " ");
        int numberOfWords = wordCounterUtility.wordCounter(words);

    }
}
