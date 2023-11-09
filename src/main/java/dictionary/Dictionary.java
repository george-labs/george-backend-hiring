package dictionary;

import textProcessing.FileLineReader;

import java.util.HashSet;

public class Dictionary {

    private final FileLineReader fileReader;
    private final HashSet<String> dictionary;

    public Dictionary(FileLineReader fileReader) {
        this.fileReader = fileReader;
        this.dictionary = new HashSet<>();
    }

    public void loadAllWords() {
        String word;
        while((word = fileReader.getLine()) != null) {
            this.dictionary.add(word);
        }
    }

    public boolean isInDict(String word) {
        return this.dictionary.contains(word);
    }
}
