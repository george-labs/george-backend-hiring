package application.text;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class Text {
    private final static String SPACE = " ";
    private final static String ALPHABETIC_REGEX = "[a-zA-Z]+";

    private final String sentenceValue;

    public Text(final String sentenceValue) {
        this.sentenceValue = sentenceValue;
    }

    public Long calculateWordsInText(final List<String> stopWords) {
        return ofNullable(sentenceValue)
                .map(sentence -> stream(sentence.split(SPACE))
                        .filter(word -> !stopWords.contains(word) && word.matches(ALPHABETIC_REGEX))
                        .count()
                )
                .orElse(0L);
    }

    public Long calculateUniqueWordsInText(final List<String> stopWords) {
        return ofNullable(sentenceValue)
                .map(sentence -> calculateUniqueWords(stream(sentence.split(SPACE))
                        .filter(word -> !stopWords.contains(word) && word.matches(ALPHABETIC_REGEX))
                        .collect(toList()))
                )
                .orElse(0L);
    }

    private Long calculateUniqueWords(final List<String> words) {
        final Map<String, Integer> wordsCounter = new HashMap<>();

        words.forEach(word -> {
            if(wordsCounter.containsKey(word)) {
                final Integer currentCount = wordsCounter.get(word) + 1;
                wordsCounter.put(word, currentCount);
            } else {
                wordsCounter.put(word, 1);
            }
        });

        return wordsCounter.values().stream().filter(wordOccurence -> wordOccurence == 1).count();
    }
}
