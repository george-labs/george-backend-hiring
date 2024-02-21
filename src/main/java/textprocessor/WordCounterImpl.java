package textprocessor;

import java.util.HashSet;
import java.util.Set;

public class WordCounterImpl implements WordsCounter {
    private StopWordsChecker stopWordsChecker;

    public WordCounterImpl(StopWordsChecker stopWordsChecker) {
        this.stopWordsChecker = stopWordsChecker;
    }

    @Override
    public int countWords(String text) {
        Set<String> uniqueWords = new HashSet<>();

        int counter = 0;
        char[] chars = (text + " ").toCharArray();
        StringBuilder wordBuilder = new StringBuilder();
        for (char ch : chars) {
            boolean isCharLetter = Character.isLetter(ch);

            if (isCharLetter) {
                wordBuilder.append(ch);
                continue;
            }

            String word = wordBuilder.toString();
            if (word.isEmpty()) {
                continue;
            }

            if (!stopWordsChecker.isStopWord(word.toLowerCase())) {
                counter++;
            }

            wordBuilder.setLength(0);
        }


        return counter;
    }
}
