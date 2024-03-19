package interview.presenter;

import interview.business.WordCounter;
import interview.output.WordCountOutput;

/**
 * @author : Xenofon Zinoviou
 */
public class WordCountPresenter {

    private final WordCounter wordCounter;

    public WordCountPresenter(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public void presentWordCount() {
        final WordCountOutput output = wordCounter.processInput();
        System.out.printf("Number of words: %d", output.getTotalWords());
    }
}
