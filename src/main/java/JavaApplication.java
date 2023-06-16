import exception.IterationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JavaApplication {

    private String fileName;
    private String enCharacters = Pattern.compile("[^a-zA-Z]").toString();

    public JavaApplication(String fileName) {
        this.fileName = fileName;
    }

    public int count(String sentence) throws IOException, IterationException {
        validationSentence(sentence);

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

    private void validationSentence(String sentence) throws IterationException {
        if (sentence.isBlank()) {
            throw new IterationException("The entire sentence is not correct");
        }
    }

    private Set<String> fetchStopWords() throws IOException {
        return Files.lines(Paths.get(this.fileName)).collect(Collectors.toSet());
    }

}
