package interview.presenter;

import interview.output.WordCountOutput;

/**
 * @author : Xenofon Zinoviou
 */
public class WordCountPresenter {

    public void presentWordCount(WordCountOutput output) {
        System.out.printf("Number of words: %d", output.getTotalWords());
    }
}
