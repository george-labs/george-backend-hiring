import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WordCount {

    private static final  Predicate<String> isEmpty = String::isEmpty;
    private static final Predicate<String> isAWord = s -> (s.matches("[a-zA-Z]+") || s.matches("[a-zA-Z]+-[a-zA-Z]+"));
    private static final Function<List<String>, Predicate<String>> isInList = list -> list::contains;
    private static final Function<Set<String>, Predicate<String>> uniqueWords = uniqueWords -> uniqueWords::add;

    public static WordCountResult count(String text) {
        return count(text, Collections.emptyList());
    }

    public static WordCountResult count(String text, List<String> filterList) {
        Set<String> uniqueWords = new HashSet<>();
        List<Predicate<String>> predicatesWord = predicateForWords(filterList);
        List<Predicate<String>> predicatesUniqueWord = predicateForUniqueWords(filterList, uniqueWords);

        return new  WordCountResult(
                countWords(text, predicatesWord),
                countWords(text, predicatesUniqueWord),
                sumOfLengthOfWords(text, predicatesWord),
                uniqueWords);
    }

    private static List<Predicate<String>> predicateForWords(List<String> filterList) {
        Predicate<String> isNotInList = isInList.apply(filterList).negate();
        return List.of(isEmpty.negate(), isAWord, isNotInList);
    }

    private static List<Predicate<String>> predicateForUniqueWords(List<String> filterList, Set<String> emptySet) {
        Predicate<String> isUniqueWord = uniqueWords.apply(emptySet);
        Predicate<String> isNotInList = isInList.apply(filterList).negate();
        return List.of(isEmpty.negate(), isAWord, isNotInList, isUniqueWord);
    }
    private static Long countWords(String text, List<Predicate<String>> predicates) {
        return filterByPredicate(text,  predicates.stream()
                .reduce(Predicate::and)
                .orElse( x -> true))
                .count();
    }

    private static Integer sumOfLengthOfWords(String s, List<Predicate<String>> predicates) {
        return filterByPredicate(s, predicates.stream()
                .reduce(Predicate::and)
                .orElse(x -> true))
                .mapToInt(String::length)
                .sum();
    }

    private static Stream<String> filterByPredicate(String s, Predicate<String> filter) {
        String[] wordsSplitted = s.split("\\s+");
        if (wordsSplitted.length == 0) {
            return Stream.empty();
        }
        return Arrays.stream(wordsSplitted)
                .filter(filter);
    }
}
