package bl;

import java.util.Scanner;

public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordCountService wordCountService = new WordCountServiceImpl(stopWordsProvider);

    public void run() {
        System.out.println("Enter text: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        long count = wordCountService.countWords(userInput);
        System.out.println("Number of words: " + count);
    }
}
