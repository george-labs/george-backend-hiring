package george.coding.challenge.job;

import java.util.regex.MatchResult;

public interface Parser {
    Result parse(String text);

    String regex();

    String wordSeparator();

    boolean predicate(MatchResult predicate);
}
