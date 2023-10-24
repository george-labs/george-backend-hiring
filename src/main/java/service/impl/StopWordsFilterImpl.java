package service.impl;

import model.Words;
import repository.StopWordsRepository;
import service.Filter;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsFilterImpl implements Filter {

    private final StopWordsRepository stopWordsRepository;

    public StopWordsFilterImpl(StopWordsRepository stopWordsRepository) {
        this.stopWordsRepository = stopWordsRepository;
    }

    @Override
    public Words filter(Words words) {
        if (Objects.isNull(words.getWords())) {
            return words;
        }

        return filterOutStopWords(words);
    }

    private Words filterOutStopWords(Words words) {
        Set<String> stopWords = stopWordsRepository.fetchAll();

        List<String> collect = words.getWords().stream()
                .filter(word -> isNonStopWord(stopWords, word))
                .collect(Collectors.toList());

        words.setWords(collect);
        return words;
    }

    private boolean isNonStopWord(Set<String> stopWords, String word) {
        return !stopWords.contains(word);
    }
}
