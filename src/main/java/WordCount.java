import java.util.Arrays;
import java.util.Scanner;

public class WordCount {
    public Long count(String s) {
        if (s.isEmpty()) {
            return 0L;
        }
        String[] stringSplitted = s.split("\\s+");
        return Arrays.stream(stringSplitted)
                .filter(s1 -> !s1.isEmpty() && !containsSymbol(s1))
                .count();
    }

    private boolean containsSymbol(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isLetter(c))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        WordCount wordCount = new WordCount();
        System.out.println("Number of words: " + wordCount.count(input));
    }
}
