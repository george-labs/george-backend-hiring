package textProcessing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineProcessor {

    public List<String> getWords(String line) {
        Stream<String> words = Stream.of(line.trim().split(" "));
        // TODO: Check if alphabetic
        return words.collect(Collectors.toList());
    }
}
