public class WordCounterApplication {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        final WordCounter wordCounter = new WordCounterImpl();

        final WordCounterService wordCounterService = new WordCounterServiceImpl(wordCounter);

        wordCounterService.countWords();
    }

}
