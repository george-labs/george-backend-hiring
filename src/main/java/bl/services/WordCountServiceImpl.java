package bl.services;

import bl.model.WordCount;
import bl.providers.StopWordsProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountServiceImpl implements WordCountService {

    private final StopWordsProvider stopWordsProvider;

    public WordCountServiceImpl(StopWordsProvider stopWordsProvider) {
        this.stopWordsProvider = stopWordsProvider;
    }

    @Override
    public WordCount countWords(String input) {
        if (input == null) {
            return new WordCount(0, 0);
        }

        Set<String> stopWords = stopWordsProvider.getStopWords();

        String[] wordCandidates = input.split("[\\s-]+");
        List<String> words = Arrays.stream(wordCandidates)
                .map(candidate -> candidate.replaceAll("[.,?!]$", ""))
                .filter(candidate -> candidate.matches("[a-zA-Z]+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .collect(Collectors.toList());
        Set<String> uniqueWords = new HashSet<>(words);

        return new WordCount(words.size(), uniqueWords.size());
    }
}
