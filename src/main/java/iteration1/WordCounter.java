package iteration1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private String fileName;
    private String enCharacters = Pattern.compile("[^a-zA-Z]").toString();

    public WordCounter(String fileName) {
        this.fileName = fileName;
    }

    public int count(String sentence) throws IOException {
        AtomicInteger counter = new AtomicInteger(0);
        Set<String> stopWords = fetchStopWords();
        List<String> words = Arrays.stream(sentence.split(" "))
                .map(word -> word.replaceAll(enCharacters, ""))
                .collect(Collectors.toList());

        words.forEach(word -> {
            boolean isStopWordMatch = stopWords.parallelStream()
                    .anyMatch(word::equals);

            if (!isStopWordMatch) {
                counter.getAndIncrement();
            }
        });

        return counter.get();
    }

    private Set<String> fetchStopWords() throws IOException {
        String stopWordSentence = Files.readString(Paths.get(this.fileName));

        return Set.of(stopWordSentence.split(" "));
    }

}
