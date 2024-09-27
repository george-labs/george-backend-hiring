package george.coding.challenge.job;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class WordCountParser implements Parser {

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
        return true;
    }
}
