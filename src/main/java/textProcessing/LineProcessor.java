package textProcessing;

import wordFilter.AlphabeticWordFilter;
import wordFilter.WordFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineProcessor {

    private final ArrayList<WordFilter> filters;

    public LineProcessor() {
        this.filters = new ArrayList<>();
    }

    public LineProcessor addFilter(WordFilter filter) {
        filters.add(filter);
        return this;
    }

    public List<String> getWords(String line) {
        Stream<String> words = Stream.of(line.trim().split(" "));
        for(WordFilter f : filters) {
            words = words.filter(f::isWord);
        }
        return words.collect(Collectors.toList());
    }
}
