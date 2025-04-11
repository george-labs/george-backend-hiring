package util.index;

import java.util.List;
import java.util.stream.Collectors;

public class IndexCreator {

    public String createIndex(List<String> words) {

        if (words == null || words.isEmpty()) {
            return "";
        }

        return words.stream().sorted().collect(Collectors.joining("\n"));
    }
}
