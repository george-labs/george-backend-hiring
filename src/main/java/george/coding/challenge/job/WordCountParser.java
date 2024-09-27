package george.coding.challenge.job;

import george.coding.challenge.job.provider.DataProvider;

import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static george.coding.challenge.Consts.EXCLUDED_WORDS_FILENAME;

public class WordCountParser implements Parser {

    private final DataProvider dataProvider;

    public WordCountParser() throws IOException {
        dataProvider = new DataProvider(EXCLUDED_WORDS_FILENAME);
    }

    @Override
    public Result parse(String text) {
        int wordCount = Math.toIntExact(Pattern.compile(wordSeparator())
                .splitAsStream(text)
                .flatMap(word -> Pattern.compile(regex()).matcher(word).results().filter(this::predicate))
                .count());

        return new Result(wordCount);
    }

    @Override
    public String regex() {
        return "[a-zA-Z]+";
    }

    @Override
    public String wordSeparator() {
        return "\\s+";
    }

    @Override
    public boolean predicate(MatchResult matchResult) {
        var stream = dataProvider.words();
        return !stream.contains(matchResult.group());
    }
}
