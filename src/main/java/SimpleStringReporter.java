public class SimpleStringReporter implements Reporter{

    public static final String WORD_COUNT_MESSAGE = "Word count ";

    @Override
    public String report(int wordCount){
        return WORD_COUNT_MESSAGE + wordCount;
    }
}
