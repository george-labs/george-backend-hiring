package wordcounter.service;

import wordcounter.model.WordCountDto;

import java.util.List;
import java.util.Set;

public class WordCounterService {

    private final StopWordsService stopWordsService;

    public WordCounterService(StopWordsService stopWordsService) {
        this.stopWordsService = stopWordsService;
    }

    public WordCountDto countWords(String text) {
        List<String> words = splitTextForWords(text);

        List<String> validWords = words.stream()
                .filter(this::isValidWord)
                .toList();

        long count = validWords.size();
        long uniqueWords = validWords.stream().distinct().count();
        double averageLength = validWords.stream()
                .map(String::length)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        return new WordCountDto(count, uniqueWords, averageLength, validWords);
    }

    private List<String> splitTextForWords(String text) {
        String[] words = text.split("[\\s.?!,]+");
        return List.of(words);
    }

    private boolean isValidWord(String word) {
        Set<String> stopWords = stopWordsService.getStopWords();
        return word.matches("[a-zA-Z-]+") && !stopWords.contains(word);
    }

}
