import java.util.Scanner;

public class WordCount {
    private final static String WORD_LETTER_PATTERN = "[a-zA-Z]+";
    private final static String WHITESPACE_PATTERN = "\\s+";

    private static boolean containsOnlyLetters(String[] wordArray) {
        for (String word : wordArray) {
            if (!word.matches(WORD_LETTER_PATTERN)) {
                return false;
            }
        }
        return true;
    }

    public static int countText(String text) {
        if(text.isEmpty()) return 0;
        String[] wordArray = text.split(WHITESPACE_PATTERN);
        if(!containsOnlyLetters(wordArray)) {
            throw new IllegalArgumentException("Text containing non allowed characters");
        }
        return wordArray.length;
    }

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int wordCount = countText(scanner.nextLine());
            System.out.println("Number of words: " + wordCount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        }
        scanner.close();
    }
}
