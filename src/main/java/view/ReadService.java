package view;

import java.util.Scanner;

public class ReadService {

    public static final String MATCH_ONLY_WORD_REGEX = "^[a-zA-Z]+$";
    private final Scanner scanner;

    public ReadService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getWordsCount() {
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        String[] words = input.split(" ");

        return getValidWordCount(words);
    }

    private int getValidWordCount(String[] words) {
        int validWordCount = 0;

        for (String word: words) {
            if(isRealWord(word)) {
                validWordCount++;
            }
        }
        return validWordCount;
    }

    private boolean isRealWord(String word) {
        return word.matches(MATCH_ONLY_WORD_REGEX);
    }
}
