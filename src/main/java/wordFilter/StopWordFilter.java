package wordFilter;

import dictionary.Dictionary;

public class StopWordFilter implements WordFilter{

    private final Dictionary dictionary;

    public StopWordFilter(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    @Override
    public boolean isWord(String word) {
        return !this.dictionary.isInDict(word);
    }
}
