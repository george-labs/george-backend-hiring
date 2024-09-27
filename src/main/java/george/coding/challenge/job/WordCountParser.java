package george.coding.challenge.job;

import george.coding.challenge.job.provider.DataProvider;

import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static george.coding.challenge.Constants.EXCLUDED_WORDS_FILENAME;

public class WordCountParser implements Parser {

    private final DataProvider dataProvider;

    public WordCountParser() throws IOException {
        dataProvider = new DataProvider(EXCLUDED_WORDS_FILENAME);
    }

    @Override
    public Result parse(String text) {
        var words = Pattern.compile(wordSeparator())
                .splitAsStream(text)
                .flatMap(word -> Pattern.compile(regex()).matcher(word).results().filter(this::matches))
                .toList();

        var wordCount = words.size();
        var sumLength = words.stream().mapToInt(value -> value.group().length()).sum();
        var uniqueWordsCount = Math.toIntExact(words.stream().map(MatchResult::group).distinct().count());

        return new Result(wordCount, uniqueWordsCount, wordCount > 0 ? (double) sumLength / wordCount : 0);
    }

    @Override
    public String regex() {
        return "[a-zA-Z\\-]+";
    }

    @Override
    public String wordSeparator() {
        return " ";
    }

    @Override
    public boolean matches(MatchResult matchResult) {
        var stream = dataProvider.words();
        return !stream.contains(matchResult.group());
    }
}
