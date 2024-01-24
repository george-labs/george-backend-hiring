package rules;

import java.util.Set;

public class StopWordsRule implements IRule{
    private final Set<String> stopWords;

    public StopWordsRule(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public boolean isValid(String word) {
        if(!stopWords.contains(word.toLowerCase())){
            return false;
        }
        return true;
    }


}
