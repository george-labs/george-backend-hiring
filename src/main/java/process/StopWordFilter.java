package process;

import exception.IterationException;
import read.Reader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordFilter implements WordFilter {

    private String ACCEPTANCE_CHARACTERS = Pattern.compile("[^a-zA-Z]").toString();

    private Reader stopWordReader;
    private Reader inputReader;

    public StopWordFilter(Reader stopWordReader, Reader inputReader) {
        this.stopWordReader = stopWordReader;
        this.inputReader = inputReader;
    }

    @Override
    public Stream<String> filter() throws IOException, IterationException {
        Set<String> stopWords = stopWordReader.read().collect(Collectors.toSet());
        List<String> words = Arrays.stream(inputReader.read().collect(Collectors.joining())
                .split(" "))
                .map(word -> word.replaceAll(ACCEPTANCE_CHARACTERS, ""))
                .collect(Collectors.toList());

        return words.stream()
                .filter(word -> stopWords.stream().noneMatch(word::equals));
    }
}
