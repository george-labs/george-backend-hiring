package textprocessor;

public class WordCounterImpl extends AbstractWordCounter implements WordsCounter {

    public WordCounterImpl(StopWordsChecker stopWordsChecker) {
        super(stopWordsChecker);
    }

    @Override
    public int countWords(String text) {
        return super.countWordsUnique(text).getCount();
    }
}
