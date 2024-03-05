package bl.services;

import bl.model.WordStats;
import bl.providers.StopWordsProvider;

import java.util.*;
import java.util.stream.Collectors;

public class WordStatsServiceImpl implements WordStatsService {

    private final StopWordsProvider stopWordsProvider;

    public WordStatsServiceImpl(StopWordsProvider stopWordsProvider) {
        this.stopWordsProvider = stopWordsProvider;
    }

    @Override
    public WordStats countWords(String input, boolean createIndex) {
        if (input == null) {
            return new WordStats(0, 0, 0.0);
        }

        List<String> words = extractWords(input);
        Set<String> uniqueWords = new HashSet<>(words);
        double avg = calcAvg(words);

        return new WordStats(words.size(), uniqueWords.size(), avg, createIndex(uniqueWords, createIndex));
    }

    private List<String> extractWords(String input) {
        Set<String> stopWords = stopWordsProvider.getStopWords();
        String[] wordCandidates = input.split("\\s+");

        return Arrays.stream(wordCandidates)
                .map(candidate -> candidate.replaceAll("[.,?!]$", ""))
                .filter(candidate -> candidate.matches("[a-zA-Z\\-]+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .collect(Collectors.toList());
    }

    private double calcAvg(List<String> words) {
        if (words.isEmpty()) {
            return 0.0;
        }
        double totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return totalLength / words.size();
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
