import java.util.*;
import java.util.function.Predicate;

public class WordCount {

    /**
     *
     * @param text
     * @return
     */

    public WordCountResult count(String text) {
        return count(text, Collections.emptyList());
    }

    public WordCountResult count(String text, List<String> filterList) {
        Long numberWords = countWords(text, filterList);
        Long numberOfUniqueWords = countUniqueWords(text, filterList);
        return new WordCountResult(numberWords, numberOfUniqueWords);
    }
    private Long countWords(String s) {
        return countWords(s, Collections.emptyList());
    }

    private Long countWords(String s, List<String> filterList) {
        return countWords(s, s1 -> !s1.isEmpty() && !containsSymbol(s1) && !filterList.contains(s1));
    }

    private Long countUniqueWords(String text) {
        return countUniqueWords(text, Collections.emptyList());
    }

    private Long countUniqueWords(String text, List<String> filterList)  {
        Set<String> uniqueWords = new HashSet<>();
        return countWords(text, s1 -> !s1.isEmpty() && !containsSymbol(s1) && !filterList.contains(s1) && uniqueWords.add(s1));
    }

    private Long countWords(String s, Predicate<String> p) {
        if (s.isEmpty()) {
            return 0L;
        }
        String[] stringSplitted = s.split("\\s+");
        return Arrays.stream(stringSplitted)
                .filter(p)
                .count();
    }

    private boolean containsSymbol(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isLetter(c))
                return true;
        }
        return false;
    }
}
