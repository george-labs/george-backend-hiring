import java.util.Arrays;
import java.util.List;

public interface WordsProvider {
    List<String> provideWords();

    default List<String> splitWords(String input) {
        //split according spaces
        return Arrays.stream(input.split("\\s+")).toList();
    }
}
