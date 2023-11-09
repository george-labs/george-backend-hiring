package dictionary;

import textProcessing.FileLineReader;
import textProcessing.LineReader;

import java.util.HashSet;

public class Dictionary {

    private final LineReader fileReader;
    private final HashSet<String> dictionary;

    public Dictionary(LineReader fileReader) {
        this.fileReader = fileReader;
        this.dictionary = new HashSet<>();

        loadAllWords();
    }

    private void loadAllWords() {
        String word;
        while((word = fileReader.getLine()) != null) {
            this.dictionary.add(word.toLowerCase());
        }
    }

    public boolean isInDict(String word) {
        return this.dictionary.contains(word);
    }
}
