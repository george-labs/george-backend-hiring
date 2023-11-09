package textProcessing;


import java.util.LinkedList;
import java.util.List;

public class WordFetcher {

    private final LineProcessor lineProcessor;
    private final LineReader lineReader;
    private final LinkedList<String> words;

    public WordFetcher(LineReader lineReader, LineProcessor lineProcessor) {
        this.words = new LinkedList<>();
        this.lineReader = lineReader;
        this.lineProcessor = lineProcessor;
    }

    public String getNextWord() {
        if (words.isEmpty()) {
            String line;
            while ((line = lineReader.getLine()) != null) {
                List<String> newWords = lineProcessor.getWords(line);
                if (!newWords.isEmpty()) {
                    words.addAll(newWords);
                    String word = words.get(0);
                    words.remove(0);
                    return word;
                }
            }
            return null;
        } else {
            String word = words.get(0);
            words.remove(0);
            return word;
        }
    }
}
