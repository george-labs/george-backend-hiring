package processors;

import rules.IRule;

import java.util.List;

public class WordCounterEngine {
    private final List<IRule> rules;

    public WordCounterEngine(List<IRule> rules) {
        this.rules = rules;
    }

    public int wordCounter(String[] words) {
        int numberOfWords = 0;

        for (String word : words
        ) {
            if (isValidWord(word)) {
                numberOfWords++;
            }
        }
        return numberOfWords;
    }

    private boolean isValidWord(String word) {
        for (IRule rule : rules) {
            if (!rule.isValid(word)) {
                return false;
            }
        }
        return true;
    }

    public String[] senteceSplitter(String sentence, String regex) {
        if (sentence.isEmpty() || sentence.isBlank()) {
            return new String[]{};
        }
        return sentence.split(regex);

    }
}
