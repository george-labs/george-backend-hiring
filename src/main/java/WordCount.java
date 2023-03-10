import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCount {
    public Long count(String s) {
        return count(s, Collections.emptyList());
    }

    public Long count(String s, List<String> filterList) {
        if (s.isEmpty()) {
            return 0L;
        }
        String[] stringSplitted = s.split("\\s+");
        return Arrays.stream(stringSplitted)
                .filter(s1 -> !s1.isEmpty() && !containsSymbol(s1) && !filterList.contains(s1))
                .count();
    }

    private boolean containsSymbol(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isLetter(c))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StopWordReader stopWordReader = new StopWordReader("stopwords.txt");
        stopWordReader.read();
        System.out.println("Enter text:");
        String input = sc.nextLine();
        WordCount wordCount = new WordCount();
        System.out.println("Number of words: " + wordCount.count(input, stopWordReader.getWordsToFilterOut()));
    }
}
