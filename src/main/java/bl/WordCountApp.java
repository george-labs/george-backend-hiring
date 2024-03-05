package bl;


public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordCountService wordCountService = new WordCountServiceImpl(stopWordsProvider);
    private final InputProvider inputProvider;

    public WordCountApp(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void run() {
        String userInput = inputProvider.getInput();

        long count = wordCountService.countWords(userInput);
        System.out.println("Number of words: " + count);
    }
}
