package service.impl;

import model.Words;
import repository.StopWordsRepository;
import service.Filter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StopWordsFilterImpl implements Filter {

    private final StopWordsRepository repository;

    public StopWordsFilterImpl(StopWordsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Words filter(Words words) {
        if (Objects.isNull(words.getWords())) {
            return words;
        }

        return filterOutStopWords(words);
    }

    private Words filterOutStopWords(Words words) {
        List<String> collect = words.getWords().stream()
                .filter(this::isNonStopWord)
                .collect(Collectors.toList());
        words.setWords(collect);
        return words;
    }

    private boolean isNonStopWord(String word) {
        return !repository.fetch().contains(word);
    }
}
