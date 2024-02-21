package textprocessor;

public class UniqueWordsCounterImpl extends AbstractWordCounter implements UniqueWordsCounter {
    public UniqueWordsCounterImpl(StopWordsChecker stopWordsChecker) {
        super(stopWordsChecker);
    }

    @Override
    public WordsCount countWords(String text) {
        return super.countWordsUnique(text);
    }
}
