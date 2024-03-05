package bl.services;

import bl.model.WordStats;
import bl.providers.StopWordsProvider;

import java.util.*;
import java.util.stream.Collectors;

public class WordCountServiceImpl implements WordCountService {

    private final StopWordsProvider stopWordsProvider;

    public WordCountServiceImpl(StopWordsProvider stopWordsProvider) {
        this.stopWordsProvider = stopWordsProvider;
    }

    @Override
    public WordStats countWords(String input, boolean createIndex) {
        if (input == null) {
            return new WordStats(0, 0, 0.0);
        }

        Set<String> stopWords = stopWordsProvider.getStopWords();

        String[] wordCandidates = input.split("\\s+");

        List<String> words = Arrays.stream(wordCandidates)
                .map(candidate -> candidate.replaceAll("[.,?!]$", ""))
                .filter(candidate -> candidate.matches("[a-zA-Z\\-]+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .collect(Collectors.toList());
        Set<String> uniqueWords = new HashSet<>(words);

        double totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }

        return new WordStats(words.size(), uniqueWords.size(), totalLength / words.size(), createIndex(uniqueWords, createIndex));
    }

    private List<String> createIndex(Set<String> words, boolean createIndex) {
        if (!createIndex) {
            return null;
        }
        List<String> index = new ArrayList<>(words);
        index.sort(String::compareToIgnoreCase);
        return index;
    }
}
