import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounterImpl implements WordCounter {

    private final Pattern pattern = Pattern.compile("^[a-zA-Z-]+\\.?$");
    private final StopWords stopWords;
    private final WordCounterResolver wordCounterResolver;

    public WordCounterImpl(StopWords stopWords, WordCounterResolver wordCounterResolver) {
        this.stopWords = stopWords;
        this.wordCounterResolver = wordCounterResolver;
    }

    @Override
    public WordCounterResult getResult() {
        String sentence = wordCounterResolver.resolve();
        WordCounterResult wordCounterResult = new WordCounterResult();
        if (sentence == null) {
            return wordCounterResult;
        }

        List<String> words = getWords(sentence);
        List<String> allWords = filterStopWords(words);
        Set<String> uniqueWords = new HashSet<>(allWords);

        wordCounterResult.setCount(allWords.size());
        wordCounterResult.setUnique(uniqueWords.size());

        return wordCounterResult;
    }

    private List<String> getWords(String sentence) {
        String[] split = sentence.split("[\\s]+");
        if (split.length < 1) {
            return Collections.emptyList();
        }

        List<String> words = Arrays.stream(split).filter(w -> {
            Matcher matcher = pattern.matcher(w);
            return matcher.matches();
        }).collect(Collectors.toList());


        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (word.contains(".")) {
                words.set(i, word.replace(".", ""));
            }
        }

        return words;
    }

    private List<String> filterStopWords(List<String> words) {
        List<String> stopWordsList = stopWords.getStopWords();
        return words.stream().filter(w -> !stopWordsList.contains(w)).collect(Collectors.toList());
    }
}
