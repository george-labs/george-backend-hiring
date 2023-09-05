public class WordCounterApplication {

    public static void main(String[] args) {
        final WordCounter wordCounter = new WordCounterImpl();

        final WordCounterService wordCounterService = new WordCounterServiceImpl(wordCounter);

        wordCounterService.countWords();
    }

}
