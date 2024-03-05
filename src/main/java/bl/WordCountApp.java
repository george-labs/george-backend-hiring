package bl;

import java.util.Scanner;

public class WordCountApp {

    private final WordCountService wordCountService = new WordCountServiceImpl();

    public void run() {
        System.out.println("Enter text: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        long count = wordCountService.countWords(userInput);
        System.out.println("Number of words: " + count);
    }
}
